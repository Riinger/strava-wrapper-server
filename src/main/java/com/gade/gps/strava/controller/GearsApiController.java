package com.gade.gps.strava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.service.GearService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
@RestController
public class GearsApiController {
	
	@Autowired GearService service;
	
    @GetMapping(
        value = "/gears/{id}",
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    @ResponseStatus(HttpStatus.OK)
    
    public DetailedGear getGearId(
        @Parameter(name = "id", in = ParameterIn.PATH) @Valid @RequestParam(required = true) @Nullable String gearId
    ) {
	
		try {
			return service.getGearById(gearId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new StravaApplicationRuntimeException("Service failed : " + e.getMessage());
		}
    }
}
