package com.gade.gps.strava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ObjectMapperConfig {
	@Autowired private Jackson2ObjectMapperBuilder objectMapperBuilder;

    @Bean
    public ObjectMapper objectMapper() {
    	return objectMapperBuilder
    			.build()
    			.setSerializationInclusion(Include.NON_NULL);
//        ObjectMapper mapper = new ObjectMapper();
//
//        // Custom settings go here...
//
//        return mapper;
    }
}
