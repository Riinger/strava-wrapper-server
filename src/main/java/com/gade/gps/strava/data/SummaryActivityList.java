package com.gade.gps.strava.data;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.gade.gps.strava.config.StravaProperties;
import com.gade.gps.strava.repository.StravaRepository;
import com.gade.gps.strava.client.model.SummaryActivity;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SummaryActivityList {
	@Autowired StravaRepository stravaRepository;
    @Autowired StravaProperties stravaProperties;
    
	GenericObjectList<SummaryActivity> activityList;
	
	boolean isCacheRefreshed = false;
    
    public List<SummaryActivity> getActivities() throws IOException, ClassNotFoundException {	  

    	activityList = new GenericObjectList<>(stravaProperties.getActivities().getCacheFile());
    	activityList.load();

    	if ( activityList.getData().isEmpty() ) {
    		// Full refresh
    		refreshCache(activityList, 0);
    	} else {
    		// We (may) need a partial refresh
    		log.debug("Get latest activities (partial cache refresh). Cache currently has {} items", activityList.getData().size());
    		SummaryActivity latest = getLatestRideTimestamp(activityList.getData());
    		// Find latest activity in cache
            log.info(String.format("BEFORE UPDATE : Most recent activity in cache is '%s' of distance %.1fkm on %s [%d]", 
            		latest.getName(), latest.getDistance() / 1000, latest.getStartDate(), latest.getStartDate().toEpochSecond()));
            refreshCache(activityList, latest.getStartDate().toEpochSecond());
            log.info(String.format("AFTER UPDATE  : Most recent activity in cache is '%s' of distance %.1fkm on %s [%d]", 
            		latest.getName(), latest.getDistance() / 1000, latest.getStartDate(), latest.getStartDate().toEpochSecond()));
    	}
    	log.debug("Cache loaded, {} items", activityList.getData().size());
    	sort();
    	activityList.save();
    	return activityList.getData();
    }
    public boolean isStale() {
    	return !isCacheRefreshed;
    }
    private void refreshCache(GenericObjectList<SummaryActivity> glo, final long after) throws IOException {
		log.info("Get all activities after {}", after);
    	int prevSize = glo.getData().size();
    	for ( int page = 1 ; ; page++ ) {
    		ResponseEntity<List<SummaryActivity>> reActivities = 
    				stravaRepository.getLoggedInAthleteActivities(Integer.MAX_VALUE, (int)after, page, 200);
    		if ( reActivities.getStatusCode() == HttpStatus.OK ) {
	    		glo.getData().addAll(reActivities.getBody());
	    		log.info("{} activities returned on page {}", glo.getData().size() - prevSize, page);
	    		if ( glo.getData().size() == prevSize ) {
	    			log.debug("{} activities read, all done", glo.getData().size());
	            	isCacheRefreshed = true;    		
	    			break;
	    		}
	    		prevSize = glo.getData().size();
    		} else {
    			log.warn("No activity data returned by Strava - {}", reActivities.getBody());
    	    	isCacheRefreshed = false;
    	    	break;
    		}
    	}
    }
	private SummaryActivity getLatestRideTimestamp(List<SummaryActivity> activityList) {
		OffsetDateTime latestRideTime = OffsetDateTime.MIN;
		SummaryActivity latestActivity = null;
		for ( var activity : activityList ) {
			if ( activity.getStartDate().isAfter(latestRideTime) ) {
				latestRideTime = activity.getStartDate();
				latestActivity = activity;
			}
		}
		log.info("Latest activity at {}", latestRideTime);
		return latestActivity;
	}
	private void sort( ) {
		activityList.getData().sort((lhs, rhs) -> lhs.getStartDate().compareTo(rhs.getStartDate()));
	}
}
