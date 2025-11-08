package com.gade.gps.strava.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;

import com.gade.gps.strava.client.ApiClient;
import com.gade.gps.strava.client.ApiException;
import com.gade.gps.strava.client.api.ActivitiesApi;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.oauth.OauthHelper;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StravaRepositoryImpl implements StravaRepository {
	@Autowired OauthHelper helper;
	
//	private ApiClient apiClient = null;
//	
//	private ApiClient getApiClient() throws IOException {
//		if ( apiClient == null ) {
//			apiClient = helper.getClient();
//		}
//		return apiClient;
//	}

	@Override
	public ResponseEntity<List<SummaryActivity>> getLoggedInAthleteActivities(int before, int after, int page, int pageSize) throws RestClientException, IOException {
//		log.debug("===> Repository layer - getLoggedInAthleteActivities()");
		List<SummaryActivity> activities = new ArrayList<>();;
//		try {
//			activities = (new ActivitiesApi(getApiClient())).getLoggedInAthleteActivities(before, after, page, pageSize);
//		} catch (ApiException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		log.debug("<=== Repository layer - getLoggedInAthleteActivities()");
		return ResponseEntity.ok(activities);
	}

}
