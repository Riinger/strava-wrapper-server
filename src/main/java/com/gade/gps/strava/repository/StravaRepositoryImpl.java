package com.gade.gps.strava.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StravaRepositoryImpl implements StravaRepository {
	public static final String ARCHIVE_FILE_EXT = "arc"; 

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
			// Write response to <api name>.<page>.<lastActivityDate>.response
			var lastDate = Optional.ofNullable(result)
				.filter(l -> !l.isEmpty())
				.map(List::getLast)
				.map(SummaryActivity::getStartDateLocal)
				.map(this::offsetDateTimeToString)
				.map(s -> "." + s)
				.orElse("");
//			var lastDate2 = Optional.ofNullable(result)
//					.filter(l -> !l.isEmpty())
//					.map(List::getLast)
//					.map(SummaryActivity::getStartDateLocal)
//					.map(OffsetDateTime::toEpochSecond)
//					.map(s -> "." + s)
//					.orElse("");
			
			try {
				archiveResponse(String.format("getLoggedInAthleteActivities.%d%s.%s", page, lastDate, ARCHIVE_FILE_EXT), objectMapper.writeValueAsString(result));
//				archiveResponse(String.format("getLoggedInAthleteActivities.%d%s.%s", page, lastDate2, ARCHIVE_FILE_EXT), objectMapper.writeValueAsString(result));
			} catch (JsonProcessingException e) {
				log.error("Uanble to convert response to string - {}", e.getMessage());
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
				archiveResponse(String.format("getGearById.%s.%s", gearId, ARCHIVE_FILE_EXT), objectMapper.writeValueAsString(result));
			} catch (JsonProcessingException e) {
				log.error("Uanble to convert response to string - {}", e.getMessage());
				throw new StravaApplicationRuntimeException(e.getMessage());
			}
		}
        return ResponseEntity.ok(result);
    }
    private void archiveResponse(String filename, String content) {
		// Write response to <page>.<lastActivityDate>.response
		var archivePath = Paths.get(stravaProperties.getArchive().getDirectory(), filename);
		log.info("Archive to file {}", archivePath.toString());
		try {
			Files.write(archivePath, content.getBytes());
		} catch(IOException ioe) {
			log.warn("Unable to create archive file - {}", ioe.getMessage());
		}
    }
    private String offsetDateTimeToString(OffsetDateTime odt) {
    	return DateTimeFormatter.ofPattern("yyyyddMM-HHmmssnnnnnn").format(odt);
    }
}
