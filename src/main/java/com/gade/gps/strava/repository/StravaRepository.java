package com.gade.gps.strava.repository;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.client.model.SummaryActivity;

public interface StravaRepository {

	public ResponseEntity<List<SummaryActivity>> getLoggedInAthleteActivities(Integer before, Integer after, Integer page, Integer pageSize);
    public ResponseEntity<DetailedGear> getGearById(String gearId);
    
    public String simple();
}
