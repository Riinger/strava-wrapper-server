package com.gade.gps.strava.oauth;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.gade.gps.strava.config.StravaAppProperties;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Component
@Data
public class StravaToken {
	@Autowired StravaAppProperties stravaProperties; // Attempts to inject via constructor seem to fail ? 

	@JsonAlias("token_type")
	private String tokenType;
	@JsonAlias("access_token")
	private String accessToken;
	@JsonAlias("expires_at")
	private long expiresAt;
	@JsonAlias("expires_in")
	private long expiresIn;
	@JsonAlias("refresh_token")
	private String refreshToken;
	
	private static final String REFRESH_TOKEN = "refresh-token";
	private static final String ACCESS_TOKEN = "access-token";
	private static final String EXPIRES_AT = "expires-at";
	private static final String EXPIRES_AT_READABLE = "expires-at-readable";

	@PostConstruct
	void init() throws IOException {
		var authProperties = loadProperties();
		
		setAccessToken(authProperties.getProperty(ACCESS_TOKEN, ""));
		setRefreshToken(authProperties.getProperty(REFRESH_TOKEN, ""));
		setExpiresAt(Long.parseLong(authProperties.getProperty(EXPIRES_AT, "0")));
	}
	private Properties loadProperties() throws IOException {
		Properties authProperties = new Properties();
		try ( var br = new BufferedReader(new FileReader(getAuthFilePath())) ) {
			authProperties.load(br);
			return authProperties;
		}
	}
	public void rewrite(StravaToken newToken) throws IOException {
		accessToken = newToken.accessToken;
		refreshToken = newToken.refreshToken;
		expiresAt = newToken.expiresAt;
		expiresIn = newToken.expiresIn;
		tokenType = newToken.tokenType;
		var authProperties = new Properties();
		authProperties.setProperty(REFRESH_TOKEN, getRefreshToken());
		authProperties.setProperty(ACCESS_TOKEN, getAccessToken());
		authProperties.setProperty(EXPIRES_AT, String.valueOf(getExpiresAt()));
		var expiresAtDateTime = LocalDateTime.ofEpochSecond(getExpiresAt(), 0, OffsetDateTime.now().getOffset());
		authProperties.setProperty(EXPIRES_AT_READABLE, expiresAtDateTime.toString());
		try ( FileOutputStream fos = new FileOutputStream(getAuthFilePath()) ) {
			authProperties.store(fos, "Strava Data");
		}
	}
	private String getAuthFilePath() {
		var authFile = stravaProperties.getAuth().getAuthFile();
		if ( authFile.startsWith("classpath:") ) {
			authFile = authFile.replace("classpath:", "");
			authFile = ClassLoader.getSystemResource(authFile).getFile();
		} else if ( authFile.startsWith("file:///") ) {
			authFile = authFile.replace("file:///", "");
		}
		return authFile;
	}
}
