package com.gade.gps.strava.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gade.gps.strava.repository.StravaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AthleteService {
//    @Autowired SummaryActivityList summaryActivityList;
//    @Autowired StravaRepository stravaRepository;
//
//    public String getActivities() throws IOException, ClassNotFoundException {	  
//    	List<SummaryActivity> activities = summaryActivityList.getActivities();
//    	for ( SummaryActivity act : activities ) {
//    		log.info("ACT DATA -> {} - {}km - {} - {}", act.getId(), (int)(act.getDistance() / 1000), act.getStartDate(), act.getName());
//    	}
//    	if ( summaryActivityList.isStale() ) {
//    		log.warn("*** Unable to retrieve the latest Strava data, some activities may be missing");
//    	}
//    	SummaryActivity lastActivity = activities.get(activities.size() - 1);
//        return String.format("Hello - last activity was '%s' of distance %.1fkm on %s [%d]", 
//        		lastActivity.getName(), lastActivity.getDistance() /  1000, lastActivity.getStartDate(), lastActivity.getStartDate().toEpochSecond());
//    }

}
