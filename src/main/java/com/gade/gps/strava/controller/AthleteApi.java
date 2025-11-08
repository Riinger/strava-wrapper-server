package com.gade.gps.strava.controller;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import com.gade.gps.strava.server.model.SportType;
import com.gade.gps.strava.server.model.SummaryActivity;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;

@Validated
@RestController
public interface AthleteApi {

//    default Optional<NativeWebRequest> getRequest() {
//        return Optional.empty();
//    }

//    @GetMapping(
//        value = "/athlete/activities",
//        produces = { "application/json" }
//    )
//    @ResponseStatus(HttpStatus.OK)
//    
//    default List<SummaryActivity> getLoggedInAthleteActivities(
//        @Parameter(name = "before", description = "An epoch timestamp to use for filtering activities that have taken place before a certain time.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "before", required = false) @Nullable Integer before,
//        @Parameter(name = "after", description = "An epoch timestamp to use for filtering activities that have taken place after a certain time.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "after", required = false) @Nullable Integer after,
//        @Parameter(name = "page", description = "Page number. Defaults to 1.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page", required = false) @Nullable Integer page,
//        @Parameter(name = "per_page", description = "Number of items per page. Defaults to 30.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "per_page", required = false, defaultValue = "30") Integer perPage
//    ) {
////        getRequest().ifPresent(request -> {
////        	var t = getRequest();
////            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
////                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
////                    String exampleString = "[ { \"comment_count\" : 7, \"average_cadence\" : 8.762042, \"upload_id\" : 6, \"private\" : true, \"distance\" : 1.4658129, \"timezone\" : \"timezone\", \"has_kudoed\" : true, \"external_id\" : \"external_id\", \"device_watts\" : true, \"type\" : \"AlpineSki\", \"manual\" : true, \"gear_id\" : \"gear_id\", \"average_heartrate\" : 6.6835623, \"elev_low\" : 9.301444, \"device_name\" : \"device_name\", \"flagged\" : true, \"trainer\" : true, \"hide_from_home\" : true, \"total_photo_count\" : 1, \"workout_type\" : 6, \"upload_id_str\" : \"upload_id_str\", \"elapsed_time\" : 5, \"id\" : 0, \"kudos_count\" : 4, \"map\" : { \"summary_polyline\" : \"summary_polyline\", \"id\" : \"id\", \"polyline\" : \"polyline\" }, \"average_speed\" : 7.4577446, \"moving_time\" : 5, \"sport_type\" : \"AlpineSki\", \"start_date\" : \"2000-01-23T04:56:07.000+00:00\", \"kilojoules\" : 4.9652185, \"athlete\" : { \"id\" : 1 }, \"athlete_count\" : 1, \"start_date_local\" : \"2000-01-23T04:56:07.000+00:00\", \"max_speed\" : 1.1730742, \"total_elevation_gain\" : 2.302136, \"average_watts\" : 5.025005, \"start_latlng\" : [ 3.6160767, 3.6160767 ], \"elev_high\" : 7.0614014, \"photo_count\" : 1, \"achievement_count\" : 2, \"max_watts\" : 9, \"name\" : \"name\", \"weighted_average_watts\" : 9, \"commute\" : true }, { \"comment_count\" : 7, \"average_cadence\" : 8.762042, \"upload_id\" : 6, \"private\" : true, \"distance\" : 1.4658129, \"timezone\" : \"timezone\", \"has_kudoed\" : true, \"external_id\" : \"external_id\", \"device_watts\" : true, \"type\" : \"AlpineSki\", \"manual\" : true, \"gear_id\" : \"gear_id\", \"average_heartrate\" : 6.6835623, \"elev_low\" : 9.301444, \"device_name\" : \"device_name\", \"flagged\" : true, \"trainer\" : true, \"hide_from_home\" : true, \"total_photo_count\" : 1, \"workout_type\" : 6, \"upload_id_str\" : \"upload_id_str\", \"elapsed_time\" : 5, \"id\" : 0, \"kudos_count\" : 4, \"map\" : { \"summary_polyline\" : \"summary_polyline\", \"id\" : \"id\", \"polyline\" : \"polyline\" }, \"average_speed\" : 7.4577446, \"moving_time\" : 5, \"sport_type\" : \"AlpineSki\", \"start_date\" : \"2000-01-23T04:56:07.000+00:00\", \"kilojoules\" : 4.9652185, \"athlete\" : { \"id\" : 1 }, \"athlete_count\" : 1, \"start_date_local\" : \"2000-01-23T04:56:07.000+00:00\", \"max_speed\" : 1.1730742, \"total_elevation_gain\" : 2.302136, \"average_watts\" : 5.025005, \"start_latlng\" : [ 3.6160767, 3.6160767 ], \"elev_high\" : 7.0614014, \"photo_count\" : 1, \"achievement_count\" : 2, \"max_watts\" : 9, \"name\" : \"name\", \"weighted_average_watts\" : 9, \"commute\" : true } ]";
////                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
////                    break;
////                }
////                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
////                    String exampleString = "{ \"message\" : \"message\", \"errors\" : [ { \"code\" : \"code\", \"field\" : \"field\", \"resource\" : \"resource\" }, { \"code\" : \"code\", \"field\" : \"field\", \"resource\" : \"resource\" } ] }";
////                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
////                    break;
////                }
////            }
////        });
//        var sa = new SummaryActivity();
//        sa.setDistance((float) 12.345);
//        sa.setStartDate(OffsetDateTime.of(2024, 1, 21, 12, 34, 56, 789, ZoneOffset.ofHours(0)));
//        sa.setName("Dummy activity");
//        sa.setDeviceName("My device");
//        sa.setElapsedTime(721);
//        sa.setSportType(SportType.BADMINTON);
//        
////        return List.of(sa);
//        
//        throw new IllegalArgumentException("Not implemented");
//
//    }


}
