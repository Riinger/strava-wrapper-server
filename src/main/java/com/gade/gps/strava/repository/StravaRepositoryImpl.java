package com.gade.gps.strava.repository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.client.api.ActivitiesApi;
import com.gade.gps.strava.client.api.GearsApi;
import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.service.AthleteService;
import com.gade.gps.strava.utils.Archiver;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StravaRepositoryImpl implements StravaRepository {

	final RepositoryHelper helper;
	final Archiver archiver;
	final ObjectMapper objectMapper;

    StravaRepositoryImpl(RepositoryHelper helper, ObjectMapper objectMapper, Archiver archiver) {
        this.helper = helper;
		this.archiver = archiver;
        this.objectMapper = objectMapper;
    }

	@Override
	public ResponseEntity<List<SummaryActivity>> getLoggedInAthleteActivities(Integer before, Integer after, Integer page, Integer pageSize) throws JsonProcessingException {
        var apiInstance = new ActivitiesApi(helper.getApiClient());
	        
        var result = apiInstance.getLoggedInAthleteActivities(before, after, page, pageSize);
        archiver.archiveResponse(AthleteService.getActivitiesArchiveFilename(page, pageSize, after, before), objectMapper.writeValueAsString(result));
        return ResponseEntity.ok(result);
	}
    @Override
	public ResponseEntity<DetailedGear> getGearById(String gearId) throws JsonProcessingException {
        var apiInstance = new GearsApi(helper.getApiClient());
	        
        var result = apiInstance.getGearById(gearId);
		archiver.archiveResponse(String.format("getGearById.%s", gearId), objectMapper.writeValueAsString(result));
        return ResponseEntity.ok(result);
    }
}
