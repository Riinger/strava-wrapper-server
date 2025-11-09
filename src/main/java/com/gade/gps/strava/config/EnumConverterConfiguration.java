package com.gade.gps.strava.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import com.gade.gps.strava.client.model.ActivityType;
import com.gade.gps.strava.client.model.SportType;

/**
 * This class provides Spring Converter beans for the enum models in the OpenAPI specification.
 *
 * By default, Spring only converts primitive types to enums using Enum::valueOf, which can prevent
 * correct conversion if the OpenAPI specification is using an `enumPropertyNaming` other than
 * `original` or the specification has an integer enum.
 */
@Configuration(value = "com.gade.gps.strava.server.config.enumConverterConfiguration")
public class EnumConverterConfiguration {

    @Bean(name = "com.gade.gps.strava.server.config.EnumConverterConfiguration.activityTypeConverter")
    Converter<String, ActivityType> activityTypeConverter() {
        return new Converter<String, ActivityType>() {
            @Override
            public ActivityType convert(String source) {
                return ActivityType.fromValue(source);
            }
        };
    }
    @Bean(name = "com.gade.gps.strava.server.config.EnumConverterConfiguration.sportTypeConverter")
    Converter<String, SportType> sportTypeConverter() {
        return new Converter<String, SportType>() {
            @Override
            public SportType convert(String source) {
                return SportType.fromValue(source);
            }
        };
    }

}
