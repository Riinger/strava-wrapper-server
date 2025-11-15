package com.gade.gps.strava.config;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gade.gps.strava.StravaDownstreamRuntimeException;
import com.gade.gps.strava.client.model.GadeError;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public static final ResponseEntity<Object> catchAllHandler(HttpServletRequest request, Exception ex) {
		 
		log.error("EXCEPTION caught : {} - {}", ex.getMessage(), Arrays.toString(ex.getStackTrace()));
		var err = new GadeError(String.format("An unexpected error (%s) occurred on call to '%s'", ex.getClass().getSimpleName(), request.getRequestURI()), ex.getMessage());
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(StravaDownstreamRuntimeException.class)
	public static final ResponseEntity<Object> catchAllHandler(StravaDownstreamRuntimeException ex) {
		 
		log.debug("Downstream error occurred : {} - {}", ex.getMessage(), Arrays.toString(ex.getStackTrace()));
		var err = new GadeError("Downstream Strava call to '" + ex.getResource() + "' failed with HTTP Status code '" + ex.getDsHttpStatus().value() + "'", ex.getMessage());
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
