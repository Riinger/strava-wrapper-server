package com.gade.gps.strava.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.gade.gps.strava.client.model.SummaryActivity;

public interface StravaRepository {

	public ResponseEntity<List<SummaryActivity>> getLoggedInAthleteActivities(int before, int after, int page, int pageSize) throws RestClientException, IOException;
}
