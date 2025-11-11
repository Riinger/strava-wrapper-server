package com.gade.gps.strava.oauth;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.ApiClient;
import com.gade.gps.strava.client.Configuration;
import com.gade.gps.strava.client.auth.OAuth;
import com.gade.gps.strava.config.StravaProperties;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OauthHelper {
	private static final String PARAM_CLIENT_SECRET = "client_secret";
	private static final String PARAM_CLIENT_ID = "client_id";
	private static final String PARAM_GRANT_TYPE = "grant_type";
	private static final String PARAM_REFRESH_TOKEN = "refresh_token";
	
	final StravaProperties stravaProperties;
	final StravaToken token;

    OauthHelper(StravaProperties stravaProperties, StravaToken token) {
        this.stravaProperties = stravaProperties;
        this.token = token;
    }
	
	public ApiClient getApiClient() throws IOException {
		ApiClient defaultClient = Configuration.getDefaultApiClient();
		// Configure OAuth2 access token for authorization: strava_oauth
		var stravaOauth = (OAuth) defaultClient.getAuthentication("strava_oauth");
		stravaOauth.setAccessToken(getAccessToken());
		return defaultClient;
	}

	private String getAccessToken() throws IOException {
		// If our token has (nearly) expired, then refresh it
		long expiresAt = token.getExpiresAt();
		LocalDateTime expiresAtDateTime = LocalDateTime.ofEpochSecond(expiresAt, 0, OffsetDateTime.now().getOffset());
		log.debug("Access token expires at {}", expiresAtDateTime);
		// Refresh the token if it expires in the next 5 minutes
		if ( LocalDateTime.now().plusMinutes(5).isBefore(expiresAtDateTime) ) {
			return token.getAccessToken();
		}
		log.debug("Access token will have expired in the next 5 minutes, so refresh");
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		Map<String, String> formParams = new HashMap<>();
		formParams.put(PARAM_CLIENT_ID, stravaProperties.getClientId());
		formParams.put(PARAM_CLIENT_SECRET, stravaProperties.getClientSecret());
		formParams.put(PARAM_GRANT_TYPE, stravaProperties.getGrantType());
		formParams.put(PARAM_REFRESH_TOKEN, token.getRefreshToken());
		
		HttpEntity<String> request = new HttpEntity<>(urlEncodeUTF8(formParams), headers);
		
		String accessTokenUrl = stravaProperties.getHostUrl() + stravaProperties.getOauthtokenUri();

		ResponseEntity<String> response = restTemplate.postForEntity(accessTokenUrl, request, String.class);

		log.debug("Access Token Response ---------" + response.getBody());
		log.debug("             Status   ---------" + response.getStatusCode());
		if ( response.getStatusCode() == HttpStatus.OK ) {
			ObjectMapper mapper = new ObjectMapper();
			token.rewrite(mapper.readValue(response.getBody(), StravaToken.class));
			log.debug("New refresh token = {}", token.getRefreshToken());
			return token.getAccessToken();
		}
		throw new StravaApplicationRuntimeException("Strava returned non-successful status code " + response.getStatusCode());
	}
	
    private static String urlEncodeUTF8(Map<String, String> map) {
    	StringBuilder sb = new StringBuilder();
    	for (Map.Entry<String, String> entry : map.entrySet()) {
	        if (!sb.isEmpty()) {
	            sb.append("&");
	        }
	        sb.append(String.format("%s=%s",
	            urlEncodeUTF8(entry.getKey()),
	            urlEncodeUTF8(entry.getValue())
	        ));
    	}
    	return sb.toString();
    }		
	private static String urlEncodeUTF8(String s) {
		try {
		    return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		    throw new UnsupportedOperationException(e);
		}
	}
}
