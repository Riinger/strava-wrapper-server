package com.gade.gps.strava.server.controller;

import com.gade.gps.strava.server.model.DetailedAthlete;
import com.gade.gps.strava.server.model.Fault;
import org.springframework.lang.Nullable;
import com.gade.gps.strava.server.model.SummaryActivity;
import com.gade.gps.strava.server.model.Zones;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
@RestController
@RequestMapping("${openapi.stravaAPIV3.base-path:/api/v3}")
public class AthleteApiController implements AthleteApi {

    private final NativeWebRequest request;

    @Autowired
    public AthleteApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
