package com.gade.gps.strava.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.config.StravaCache;
import com.gade.gps.strava.repository.StravaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GearServiceImpl implements GearService {

    final StravaRepository stravaRepository;
    final StravaCache stravaCache;
    
    public GearServiceImpl(StravaRepository stravaRepository, StravaCache stravaCache) {
    	this.stravaRepository = stravaRepository;
    	this.stravaCache = stravaCache;
    }

    @Override
    public DetailedGear getGearById(String gearId) throws JsonProcessingException {
		var response = stravaRepository.getGearById(gearId);
		if ( response.getStatusCode() == HttpStatus.OK ) {
			return response.getBody();
		}
		log.error("Unable to get gearId - {} - {}", response.getStatusCode(), response.getBody());
		throw new StravaApplicationRuntimeException("Cannot get gear id from Strava : {}" + response.getStatusCode());
	}
}
