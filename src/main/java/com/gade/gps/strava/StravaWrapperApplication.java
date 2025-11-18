package com.gade.gps.strava;

import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.Module;

@SpringBootApplication
public class StravaWrapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(StravaWrapperApplication.class, args);
    }

    @Bean(name = "com.gade.gps.strava.server.OpenApiGeneratorApplication.jsonNullableModule")
	Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}