package com.gade.gps.strava.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;

import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.api.ActivitiesApi;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.oauth.OauthHelper;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StravaRepositoryImpl implements StravaRepository {
	@Autowired OauthHelper helper;

	@Override
	public ResponseEntity<List<SummaryActivity>> getLoggedInAthleteActivities(Integer before, Integer after, Integer page, Integer pageSize) throws RestClientException, IOException {
		try {
	        ActivitiesApi apiInstance = new ActivitiesApi(helper.getApiClient());
	        
            var result = apiInstance.getLoggedInAthleteActivities(before, after, page, pageSize);
            return ResponseEntity.ok(result);

		} catch (Exception e) {
			if ( e instanceof NullPointerException npe ) {
				String msg = "Null pointer exception on downstream StravaGet call [" + npe.getMessage() + "]";
				log.error(msg);
				throw new StravaApplicationRuntimeException(msg);
			}	
			// Unsuccessful request (other error)
			String msg = "Unexpected exception on downstream StravaGet call [" + e.getMessage() + "]";
			log.error(msg);
			throw new StravaApplicationRuntimeException(msg);
		}
	}

}
