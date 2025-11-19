package com.gade.gps.strava.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@ConfigurationProperties(prefix = "strava")
@Data
@Configuration
public class StravaAppProperties {
	
	@Data
	public static class ArchiveConfig {
		private Boolean enabled;
		private String directory;
	}
	@Data
	public static class CacheConfig {
		private String path;
	}
	@Data
	public static class AuthConfig {
		private String authFile;
		private String hostUrl;
		private String oauthtokenUri;
		private String clientId;
		private String clientSecret;
		private String grantType;
		private Integer expiryBuffer = 5; // minutes
	}
	@Data
	public static class GearConfig {
		private String name;
		private String description;
	}
	
	private ArchiveConfig archive;
	private CacheConfig cache;
	private AuthConfig auth;
	private Map<String, GearConfig> gear;
}
