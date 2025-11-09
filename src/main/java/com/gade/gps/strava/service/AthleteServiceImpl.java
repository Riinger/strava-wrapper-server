package com.gade.gps.strava.service;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gade.gps.strava.client.model.SportType;
import com.gade.gps.strava.client.model.SummaryActivity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AthleteServiceImpl implements AthleteService {
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
	public List<SummaryActivity> getActivities() throws IOException, ClassNotFoundException {	  
        var sa = new SummaryActivity();
        sa.setDistance((float) 12.345);
        sa.setStartDate(OffsetDateTime.of(2024, 1, 21, 12, 34, 56, 789, ZoneOffset.ofHours(0)));
        sa.setName("Dummy activity");
        sa.setDeviceName("My device");
        sa.setElapsedTime(721);
        sa.setSportType(SportType.BADMINTON);
        
        if ( 1 == 1 ) {
        return List.of(sa);
        } else {
        
        throw new IllegalArgumentException("Not implemented");
        }

	}
}
