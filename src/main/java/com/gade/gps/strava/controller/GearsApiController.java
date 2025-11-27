package com.gade.gps.strava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.service.GearService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
@RestController
public class GearsApiController {
	
	@Autowired GearService service;
	
    @GetMapping(
        value = "/gear/{id}",
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    @ResponseStatus(HttpStatus.OK)
    
    public DetailedGear getGearId(
        @NotNull @Parameter(name = "id", description = "The identifier of the gear.", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) throws JsonProcessingException {
	
	return service.getGearById(id);
    }
}
