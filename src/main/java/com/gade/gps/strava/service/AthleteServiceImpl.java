package com.gade.gps.strava.service;

import static com.gade.gps.strava.config.StravaCache.CacheAction.NONE;
import static com.gade.gps.strava.config.StravaCache.CacheAction.UPDATE;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.model.GadeSummaryActivity;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.config.StravaCache;
import com.gade.gps.strava.config.StravaCache.CacheAction;
import com.gade.gps.strava.mappers.SummaryMapper;
import com.gade.gps.strava.repository.StravaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AthleteServiceImpl implements AthleteService {
	private static final int PAGESIZE = 200;

    final StravaRepository stravaRepository;
    final StravaCache stravaCache;
    final SummaryMapper mapper;
    
    public AthleteServiceImpl(StravaRepository stravaRepository, StravaCache stravaCache, SummaryMapper mapper) {
    	this.stravaRepository = stravaRepository;
    	this.stravaCache = stravaCache;
    	this.mapper = mapper;
    }

    @Override
	public List<GadeSummaryActivity> getActivities(Integer before, Integer after, Integer page, Integer pageSize) {
		var response = stravaRepository.getLoggedInAthleteActivities(before, after, page, pageSize);
		if ( response.getStatusCode() == HttpStatus.OK ) {
			return mapper.mapToGadeList(response.getBody());
		}
		log.error("Unable to get activities - {} - {}", response.getStatusCode(), response.getBody());
		throw new StravaApplicationRuntimeException("Cannot get activities from Strava : {}" + response.getStatusCode().value());
	}
    @Override
	public List<GadeSummaryActivity> getActivities(CacheAction cacheAction) {

    	List<SummaryActivity> activities = this.stravaCache.getCachedActivities();

    	if ( !cacheAction.equals(NONE) ) {
	    	Integer after = 0;
	    	if ( cacheAction.equals(UPDATE)) { 
	        	var latestAct = StravaCache.getLatestActivity(activities);
		    	if ( latestAct != null ) {
		    		var startDate = latestAct.getStartDate().toLocalDateTime();
		    		log.info("After {}", startDate);
		    		after = Integer.valueOf((int)OffsetDateTime.of(startDate, ZoneOffset.UTC).toEpochSecond());
		    	}
	    	} else {
	    		activities = new ArrayList<>();
	    	}
    		
	    	var allRead = false;
	    	var page = 1;
	    	while ( !allRead ) {
	    		log.info("Reading page {}", page);
		    	var activitiesFromStrava = stravaRepository.getLoggedInAthleteActivities(
		    			null,
		    			after,
		    			page++,
		    			PAGESIZE);
		    	if ( activitiesFromStrava.getStatusCode().is2xxSuccessful() ) {
		    		List<SummaryActivity> theseActivities = 
	    				Optional.ofNullable(activitiesFromStrava)
							.map(HttpEntity::getBody)
		    				.orElse(new ArrayList<>());
	    		
	    			activities.addAll(theseActivities);
	    			log.info("Strava returned {} activities on page {}", theseActivities.size(), page - 1);
		    		if ( theseActivities.size() < PAGESIZE ) allRead = true;
		    	} else {
		    		log.error("Cannot get activities from Strava : {}", activitiesFromStrava.getStatusCode());
		    		return new ArrayList<>();
		    	}
	    	}
			stravaCache.update(activities);
    	}
    	var a = mapper.mapToGadeList(activities);
    	log.info("{} activities returned", a.size());
		return mapper.mapToGadeList(activities);

	}
}
