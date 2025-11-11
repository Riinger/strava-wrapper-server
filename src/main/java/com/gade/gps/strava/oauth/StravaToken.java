package com.gade.gps.strava.oauth;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.gade.gps.strava.config.StravaProperties;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Component
@Data
public class StravaToken {
	final StravaProperties stravaProperties;

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

    StravaToken(StravaProperties stravaProperties) {
        this.stravaProperties = stravaProperties;
    }
	
	@PostConstruct
	void init() throws IOException {
		Properties authProperties = loadProperties();
		
		setAccessToken(authProperties.getProperty(ACCESS_TOKEN, ""));
		setRefreshToken(authProperties.getProperty(REFRESH_TOKEN, ""));
		setExpiresAt(Long.parseLong(authProperties.getProperty(EXPIRES_AT, "0")));
	}
	private Properties loadProperties() throws IOException {
		Properties authProperties = new Properties();
		try ( BufferedReader br = new BufferedReader(new FileReader(getAuthFilePath())) ) {
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
		Properties authProperties = new Properties();
		authProperties.setProperty(REFRESH_TOKEN, getRefreshToken());
		authProperties.setProperty(ACCESS_TOKEN, getAccessToken());
		authProperties.setProperty(EXPIRES_AT, String.valueOf(getExpiresAt()));
		LocalDateTime expiresAtDateTime = LocalDateTime.ofEpochSecond(getExpiresAt(), 0, OffsetDateTime.now().getOffset());
		authProperties.setProperty(EXPIRES_AT_READABLE, expiresAtDateTime.toString());
		try ( FileOutputStream fos = new FileOutputStream(getAuthFilePath()) ) {
			authProperties.store(fos, "Strava Data");
		}
	}
	private String getAuthFilePath() {
		String authFile = stravaProperties.getAuthFile();
		if ( authFile.startsWith("classpath:") )
		{
			authFile = authFile.replace("classpath:", "");
			authFile = ClassLoader.getSystemResource(authFile).getFile();
		}
		return authFile;
	}
}
