package com.gade.gps.strava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gade.gps.strava.client.ApiClient;
import com.gade.gps.strava.client.Configuration;
import com.gade.gps.strava.client.auth.OAuth;
import com.gade.gps.strava.config.StravaProperties;
import com.gade.gps.strava.oauth.StravaToken;

import lombok.extern.slf4j.Slf4j;

//@Component
//@Slf4j
public class StravaHelper {

//	@Autowired StravaProperties stravaProperties;
//	
//	@Autowired StravaToken token;
//	
//	public ApiClient getApiClient() {
//		
//		ApiClient defaultClient = Configuration.getDefaultApiClient();
//	
//		// Configure OAuth2 access token for authorization: strava_oauth
//		OAuth strava_oauth = (OAuth) defaultClient.getAuthentication("strava_oauth");
//		strava_oauth.setAccessToken(token.getAccessToken());
//		return defaultClient;
//	}
}