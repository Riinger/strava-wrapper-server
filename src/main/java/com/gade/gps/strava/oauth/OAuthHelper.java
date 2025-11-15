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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.config.StravaAppProperties;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OAuthHelper {
	private static final String PARAM_CLIENT_SECRET = "client_secret";
	private static final String PARAM_CLIENT_ID = "client_id";
	private static final String PARAM_GRANT_TYPE = "grant_type";
	private static final String PARAM_REFRESH_TOKEN = "refresh_token";
	
	final StravaAppProperties stravaProperties;
	final StravaToken token;

    OAuthHelper(StravaAppProperties stravaProperties, StravaToken token) {
        this.stravaProperties = stravaProperties;
        this.token = token;
    }

	public String getAccessToken() {
		// If our token has (nearly) expired, then refresh it
		var expiresAt = token.getExpiresAt();
		var expiresAtDateTime = LocalDateTime.ofEpochSecond(expiresAt, 0, OffsetDateTime.now().getOffset());
		log.debug("Access token expires at {}", expiresAtDateTime);
		// Refresh the token if it expires in the next configurable minutes (default 5)
		var stravaAuth = stravaProperties.getAuth(); 
		if ( LocalDateTime.now().plusMinutes(stravaAuth.getExpiryBuffer()).isBefore(expiresAtDateTime) ) {
			return token.getAccessToken();
		}
		log.debug("Access token will have expired in the next {} minutes, so refresh", stravaAuth.getExpiryBuffer());
		var restTemplate = new RestTemplate();
		
		var headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		Map<String, String> formParams = new HashMap<>();
		formParams.put(PARAM_CLIENT_ID, stravaAuth.getClientId());
		formParams.put(PARAM_CLIENT_SECRET, stravaAuth.getClientSecret());
		formParams.put(PARAM_GRANT_TYPE, stravaAuth.getGrantType());
		formParams.put(PARAM_REFRESH_TOKEN, token.getRefreshToken());
		
		HttpEntity<String> request = new HttpEntity<>(urlEncodeUTF8(formParams), headers);
		
		var accessTokenUrl = stravaAuth.getHostUrl() + stravaAuth.getOauthtokenUri();

		ResponseEntity<String> response = restTemplate.postForEntity(accessTokenUrl, request, String.class);

		log.debug("Access Token Response ---------" + response.getBody());
		log.debug("             Status   ---------" + response.getStatusCode());
		if ( response.getStatusCode() == HttpStatus.OK ) {
			var mapper = new ObjectMapper();
			var msg = "";
			try {
				token.rewrite(mapper.readValue(response.getBody(), StravaToken.class));
				log.debug("New refresh token = {}", token.getRefreshToken());
				return token.getAccessToken();
			} catch (JsonMappingException e) {
				msg = String.format("Access Token error : %s:%s - %s", e.getClass().getSimpleName(), e.getPathReference(), e.getMessage());
			} catch (JsonProcessingException e) {
				msg = String.format("Access Token error : %s:Line %d, Column %d - %s", e.getClass().getSimpleName(), e.getLocation().getLineNr(), e.getLocation().getColumnNr(), e.getMessage());
			} catch (IOException e) {
				msg = String.format("Access Token error : %s - %s", e.getClass().getSimpleName(), e.getMessage());
			}
			log.error(msg);
			throw new StravaApplicationRuntimeException(msg);
		}
		throw new StravaApplicationRuntimeException("Strava returned non-successful status code " + response.getStatusCode());
	}
	
    private static String urlEncodeUTF8(Map<String, String> map) {
    	var sb = new StringBuilder();
    	for (var entry : map.entrySet()) {
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
