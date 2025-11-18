package com.gade.gps.strava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gade.gps.strava.service.AdminService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	@Autowired AdminService service;
	
    @PostMapping(
        value = "/admin/cache/archive",
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    @ResponseStatus(HttpStatus.OK)
    
    public ResponseEntity<Void> archiveCachedEntries(
        @Parameter(name = "per_page", in = ParameterIn.QUERY) @Valid @RequestParam(required = false, defaultValue = "30") Integer perPage
    ) {
	
    	service.archiveCachedEntries(perPage);
		return ResponseEntity.ok().build();
    }
}
