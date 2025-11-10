package com.gade.gps.strava.service;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.config.StravaCache;
import com.gade.gps.strava.repository.StravaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AthleteServiceImpl implements AthleteService {
	private static final int PAGESIZE = 200;

    @Autowired StravaRepository stravaRepository;
    @Autowired StravaCache stravaCache;

    public List<SummaryActivity> getActivities(Integer before, Integer after, Integer page, Integer pageSize) throws IOException {
		var response = stravaRepository.getLoggedInAthleteActivities(before, after, page, pageSize);
		if ( response.getStatusCode() == HttpStatus.OK ) {
			return response.getBody();
		} else {
			log.error("Unable to get activities - {} - {}", response.getStatusCode(), response.getBody());
			throw new StravaApplicationRuntimeException("Cannot get activities from Strava : {}" + response.getStatusCode());
		}
	}
    public List<SummaryActivity> getActivities() throws IOException {
    	List<SummaryActivity> activities = stravaCache.getCachedActivities();
    	var latestAct = StravaCache.getLatestActivity(activities);
    	Integer after = null;
    	if ( latestAct != null ) {
    		var startDate = latestAct.getStartDate().toLocalDate().plusDays(1).atStartOfDay();
    		log.info("After {}", startDate);
    		after = (int)(OffsetDateTime.of(startDate, ZoneOffset.UTC).toEpochSecond());
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
		return activities;

	}
}
