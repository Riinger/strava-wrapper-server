package com.gade.gps.strava.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gade.gps.strava.client.model.GadeSummaryActivity;
import com.gade.gps.strava.config.StravaCache.CacheAction;

public interface AthleteService {
    public List<GadeSummaryActivity> getActivities(Integer before, Integer after, Integer page, Integer pageSize) throws JsonProcessingException;
    public List<GadeSummaryActivity> getActivities(CacheAction cacheAction) throws JsonProcessingException;
    
    public static String getActivitiesArchiveFilename(Integer page, Integer pageSize, Integer after, Integer before) {
    	return String.format("getLoggedInAthleteActivities%s%s%s%s", 
    			integerToStringComponent(page, 3), 
    			integerToStringComponent(pageSize, 3),
    			integerToStringComponent(after, 12),
    			integerToStringComponent(before, 12));
    }
    private static String integerToStringComponent(Integer i, int length) {
    	if ( i != null ) {
    	var format = ".%0" + length + "d";
    		return String.format(format, i); 
    	}
		return "." + "n".repeat(length);
    }
}
