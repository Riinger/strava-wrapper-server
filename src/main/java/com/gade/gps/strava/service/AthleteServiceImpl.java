package com.gade.gps.strava.service;

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
import com.gade.gps.strava.mappers.SummaryMapper;
import com.gade.gps.strava.repository.StravaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AthleteServiceImpl implements AthleteService {
	private static final int PAGESIZE = 200;

    final StravaRepository stravaRepository;
    final StravaCache stravaCache;
    
    public AthleteServiceImpl(StravaRepository stravaRepository, StravaCache stravaCache) {
    	this.stravaRepository = stravaRepository;
    	this.stravaCache = stravaCache;
    }

    @Override
	public List<GadeSummaryActivity> getActivities(Integer before, Integer after, Integer page, Integer pageSize) {
		var response = stravaRepository.getLoggedInAthleteActivities(before, after, page, pageSize);
		if ( response.getStatusCode() == HttpStatus.OK ) {
			return SummaryMapper.mapToGadeList(response.getBody());
		}
		log.error("Unable to get activities - {} - {}", response.getStatusCode(), response.getBody());
		throw new StravaApplicationRuntimeException("Cannot get activities from Strava : {}" + response.getStatusCode().value());
	}
    @Override
	public List<GadeSummaryActivity> getActivities(Boolean updateCache) {
    	List<SummaryActivity> activities = this.stravaCache.getCachedActivities();
    	var latestAct = StravaCache.getLatestActivity(activities);
    	if ( Boolean.TRUE.equals(updateCache) ) {
	    	Integer after = null;
	    	if ( latestAct != null ) {
	    		var startDate = latestAct.getStartDate().toLocalDate().plusDays(1).atStartOfDay();
	    		log.info("After {}", startDate);
	    		after = Integer.valueOf((int)OffsetDateTime.of(startDate, ZoneOffset.UTC).toEpochSecond());
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
		    		if ( theseActivities.size() < PAGESIZE ) allRead = true;
		    	} else {
		    		log.error("Cannot get activities from Strava : {}", activitiesFromStrava.getStatusCode());
		    		return new ArrayList<>();
		    	}
	    	}
			stravaCache.update(activities);
    	}
		return SummaryMapper.mapToGadeList(activities);

	}
}
