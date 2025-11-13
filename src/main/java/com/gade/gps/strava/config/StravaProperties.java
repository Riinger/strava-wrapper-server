package com.gade.gps.strava.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@ConfigurationProperties(prefix = "strava")
@PropertySource(value = "classpath:strava-config.yml", ignoreResourceNotFound = true, factory = YamlPropertySourceFactory.class)
//@PropertySource(value = "classpath:strava-config-${spring.profiles.active}.yml", ignoreResourceNotFound = true, factory = YamlPropertySourceFactory.class)
@PropertySource(value = "${strava.config}", ignoreResourceNotFound = true, factory = YamlPropertySourceFactory.class)
@Data
@Configuration
public class StravaProperties {
	private String authFile;
	private String hostUrl;
	private String oauthtokenUri;
	private String clientId;
	private String clientSecret;
	private String grantType;
	private Integer expiryBuffer = 5; // minutes
}
