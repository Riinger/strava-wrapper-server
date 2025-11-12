package com.gade.gps.strava.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;

import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.api.ActivitiesApi;
import com.gade.gps.strava.client.api.GearsApi;
import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.oauth.OAuthHelper;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StravaRepositoryImpl implements StravaRepository {
	final OAuthHelper helper;

    StravaRepositoryImpl(OAuthHelper helper) {
        this.helper = helper;
    }

	@Override
	public ResponseEntity<List<SummaryActivity>> getLoggedInAthleteActivities(Integer before, Integer after, Integer page, Integer pageSize) throws RestClientException, IOException {
		try {
	        var apiInstance = new ActivitiesApi(helper.getApiClient());
	        
            var result = apiInstance.getLoggedInAthleteActivities(before, after, page, pageSize);
            return ResponseEntity.ok(result);

		} catch (Exception e) {
			if ( e instanceof NullPointerException npe ) {
				String msg = "Null pointer exception on downstream Strava getLoggedInAthleteActivities() call [" + npe.getMessage() + "]";
				log.error(msg);
				throw new StravaApplicationRuntimeException(msg);
			}	
			// Unsuccessful request (other error)
			String msg = "Unexpected exception on downstream Strava getLoggedInAthleteActivities() call [" + e.getMessage() + "]";
			log.error(msg);
			throw new StravaApplicationRuntimeException(msg);
		}
	}
    @Override
	public ResponseEntity<DetailedGear> getGearById(String gearId) throws RestClientException, IOException {
		try {
	        var apiInstance = new GearsApi(helper.getApiClient());
	        
	        var result = apiInstance.getGearById(gearId);
	        return ResponseEntity.ok(result);
	
		} catch (Exception e) {
			if ( e instanceof NullPointerException npe ) {
				String msg = "Null pointer exception on downstream Strava getGearId() call [" + npe.getMessage() + "]";
				log.error(msg);
				throw new StravaApplicationRuntimeException(msg);
			}	
			// Unsuccessful request (other error)
			String msg = "Unexpected exception on downstream Strava getGearId() call [" + e.getMessage() + "]";
			log.error(msg);
			throw new StravaApplicationRuntimeException(msg);
		}
    }

}
