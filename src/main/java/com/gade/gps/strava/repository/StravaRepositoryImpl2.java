package com.gade.gps.strava.repository;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StravaRepositoryImpl2 implements StravaRepository2 {

//	final StravaAppProperties stravaProperties;
//
//    StravaRepositoryImpl2(StravaAppProperties stravaProperties) {
//        this.stravaProperties = stravaProperties;
//    }

	@Override
	public String simple() {
//        var apiInstance = new ActivitiesApi(helper.getApiClient());
        var dummy = new Dummy("R");
		return dummy.simpleMethod();
	}
}
