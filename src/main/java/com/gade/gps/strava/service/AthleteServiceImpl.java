package com.gade.gps.strava.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.repository.StravaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AthleteServiceImpl implements AthleteService {
    @Autowired StravaRepository stravaRepository;

    public List<SummaryActivity> getActivities(Integer before, Integer after, Integer page, Integer pageSize) throws IOException, ClassNotFoundException {	  
		var response = stravaRepository.getLoggedInAthleteActivities(before, after, page, pageSize);
		if ( response.getStatusCode() == HttpStatus.OK ) {
			return response.getBody();
		} else {
			log.error("Unable to get activities - {} - {}", response.getStatusCode(), response.getBody());
			throw new StravaApplicationRuntimeException("Cannot get activities from Strava : {}" + response.getStatusCode());
		}
	}
}
