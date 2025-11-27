package com.gade.gps.strava.repository;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.client.model.SummaryActivity;

public interface StravaRepository {

	public ResponseEntity<List<SummaryActivity>> getLoggedInAthleteActivities(Integer before, Integer after, Integer page, Integer pageSize) throws JsonProcessingException;
    public ResponseEntity<DetailedGear> getGearById(String gearId) throws JsonProcessingException;
}
