package com.gade.gps.strava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.model.GadeSummaryActivity;
import com.gade.gps.strava.service.AthleteService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
@RestController
public class AthleteApiController {
	
	@Autowired AthleteService service;
	
    @GetMapping(
        value = "/athlete/activities",
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    @ResponseStatus(HttpStatus.OK)
    
    public List<GadeSummaryActivity> getLoggedInAthleteActivities(
        @Parameter(name = "before", in = ParameterIn.QUERY) @Valid @RequestParam(required = false) @Nullable Integer before,
        @Parameter(name = "after", in = ParameterIn.QUERY) @Valid @RequestParam(required = false) @Nullable Integer after,
        @Parameter(name = "page", in = ParameterIn.QUERY) @Valid @RequestParam(required = false) @Nullable Integer page,
        @Parameter(name = "per_page", in = ParameterIn.QUERY) @Valid @RequestParam(required = false, defaultValue = "30") Integer perPage
    ) {
	
		try {
			return service.getActivities(before, after, page, perPage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new StravaApplicationRuntimeException("Service failed : " + e.getMessage());
		}
    }

    @GetMapping(
        value = "/athlete/activities/all",
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    @ResponseStatus(HttpStatus.OK)
    public List<GadeSummaryActivity> getActivities(
    		@RequestParam(name = "update_cache", required = false, defaultValue = "true") Boolean updateCache) {
		try {
			return service.getActivities(updateCache).subList(0, 2); // TODO - want request parameters to specifiy filters
		} catch (Exception e) {
			e.printStackTrace();
			throw new StravaApplicationRuntimeException("Service failed : " + e.getMessage());
		}
    }
}
