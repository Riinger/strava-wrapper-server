package com.gade.gps.strava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ObjectMapperConfig {
	private final Jackson2ObjectMapperBuilder objectMapperBuilder;

    ObjectMapperConfig(Jackson2ObjectMapperBuilder objectMapperBuilder) {
        this.objectMapperBuilder = objectMapperBuilder;
    }

    @Bean
    ObjectMapper objectMapper() {
    	return objectMapperBuilder
    			.build()
    			.setSerializationInclusion(Include.NON_NULL);
    }
}
