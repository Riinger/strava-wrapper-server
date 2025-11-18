package com.gade.gps.strava.repository;

import java.io.File;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.api.ActivitiesApi;
import com.gade.gps.strava.client.api.GearsApi;
import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.config.StravaAppProperties;
import com.gade.gps.strava.service.AthleteService;
import com.gade.gps.strava.utils.StravaHelper;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StravaRepositoryImpl implements StravaRepository {

	final RepositoryHelper helper;
	final StravaAppProperties stravaProperties;
	final ObjectMapper objectMapper;

    StravaRepositoryImpl(RepositoryHelper helper, StravaAppProperties stravaProperties, ObjectMapper objectMapper) {
        this.helper = helper;
        this.stravaProperties = stravaProperties;
        this.objectMapper = objectMapper;
    }
    @PostConstruct
    void initArchive() {
		var arcDir = new File(stravaProperties.getArchive().getDirectory());
		log.info("Create archive directory result {}", arcDir.mkdirs());
    }

	@Override
	public ResponseEntity<List<SummaryActivity>> getLoggedInAthleteActivities(Integer before, Integer after, Integer page, Integer pageSize) {
        var apiInstance = new ActivitiesApi(helper.getApiClient());
	        
        var result = apiInstance.getLoggedInAthleteActivities(before, after, page, pageSize);
		if ( Boolean.TRUE.equals(stravaProperties.getArchive().getEnabled()) ) {
			try {
				StravaHelper.archiveResponse(AthleteService.getActivitiesArchiveFilename(page, pageSize), objectMapper.writeValueAsString(result), stravaProperties.getArchive().getDirectory());
			} catch (JsonProcessingException e) {
				log.error("Unable to convert response to string - {}", e.getMessage());
				throw new StravaApplicationRuntimeException(e.getMessage());
			}
		}
        return ResponseEntity.ok(result);
	}
    @Override
	public ResponseEntity<DetailedGear> getGearById(String gearId) {
        var apiInstance = new GearsApi(helper.getApiClient());
	        
        var result = apiInstance.getGearById(gearId);
		if ( Boolean.TRUE.equals(stravaProperties.getArchive().getEnabled()) ) {
			try {
				StravaHelper.archiveResponse(String.format("getGearById.%s", gearId), objectMapper.writeValueAsString(result), stravaProperties.getArchive().getDirectory());
			} catch (JsonProcessingException e) {
				log.error("Unable to convert response to string - {}", e.getMessage());
				throw new StravaApplicationRuntimeException(e.getMessage());
			}
		}
        return ResponseEntity.ok(result);
    }
}
