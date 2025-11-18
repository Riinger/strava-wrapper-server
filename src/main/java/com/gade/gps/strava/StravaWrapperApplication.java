package com.gade.gps.strava;

import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

import com.fasterxml.jackson.databind.Module;

@SpringBootApplication
//@ComponentScan(
//	    basePackages = {"com.gade.gps.strava.client", "com.gade.gps.strava.client.api" , "org.openapitools.configuration"},
//	    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
//	)
public class StravaWrapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(StravaWrapperApplication.class, args);
    }

    @Bean(name = "com.gade.gps.strava.server.OpenApiGeneratorApplication.jsonNullableModule")
	Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}