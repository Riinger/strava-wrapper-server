package com.gade.gps.strava.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@ConfigurationProperties(prefix = "strava")
@PropertySource(value = "classpath:config.yml", ignoreResourceNotFound = true, factory = YamlPropertySourceFactory.class)
@PropertySource(value = "classpath:config-${spring.profiles.active}.yml", ignoreResourceNotFound = true, factory = YamlPropertySourceFactory.class)
@Data
@Configuration
public class StravaProperties {
	private String authFile;
	private String hostUrl;
	private String oauthtokenUri;
	private String clientId;
	private String clientSecret;
	private String grantType;
	private Activities activities;
	private Streams streams;
	
	@Data
	public static class Activities {
		private String cacheFile;
	}
	@Data
	public static class Streams {
		private String cacheFile;
	}
}
