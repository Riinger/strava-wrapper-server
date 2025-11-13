package com.gade.gps.strava.repository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.gade.gps.strava.client.api.ActivitiesApi;
import com.gade.gps.strava.client.api.GearsApi;
import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.client.model.SummaryActivity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StravaRepositoryImpl implements StravaRepository {
	final RepositoryHelper helper;

    StravaRepositoryImpl(RepositoryHelper helper) {
        this.helper = helper;
    }

	@Override
	public ResponseEntity<List<SummaryActivity>> getLoggedInAthleteActivities(Integer before, Integer after, Integer page, Integer pageSize) {
        var apiInstance = new ActivitiesApi(helper.getApiClient());
	        
        var result = apiInstance.getLoggedInAthleteActivities(before, after, page, pageSize);
        return ResponseEntity.ok(result);
	}
    @Override
	public ResponseEntity<DetailedGear> getGearById(String gearId) {
        var apiInstance = new GearsApi(helper.getApiClient());
	        
        var result = apiInstance.getGearById(gearId);
        return ResponseEntity.ok(result);
    }
}
