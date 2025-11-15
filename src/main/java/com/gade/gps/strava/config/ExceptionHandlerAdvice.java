package com.gade.gps.strava.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gade.gps.strava.StravaDownstreamRuntimeException;
import com.gade.gps.strava.client.model.GadeError;
import com.gade.gps.strava.client.model.GadeFault;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public static final ResponseEntity<Object> catchAllHandler(HttpServletRequest request, Exception ex) {
		 
		log.error("EXCEPTION caught : {} - {}", ex.getMessage(), Arrays.toString(ex.getStackTrace()));
		var errs = new ArrayList<GadeError>();
		errs.add(new GadeError(ex.getMessage(), "URI=" + request.getRequestURI()));
		errs.add(new GadeError("Exception '" + ex.getClass().getSimpleName() + "'", null));
		var fault = new GadeFault("Request failed", errs);
		return new ResponseEntity<>(fault, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(StravaDownstreamRuntimeException.class)
	public static final ResponseEntity<Object> catchAllHandler(HttpServletRequest request, StravaDownstreamRuntimeException ex) {
		 
		log.error("EXCEPTION caught : {} - {}", ex.getMessage(), Arrays.toString(ex.getStackTrace()));
		var errs = new ArrayList<GadeError>();
		errs.add(new GadeError(ex.getMessage(), "URI=" + request.getRequestURI()));
		errs.add(new GadeError("Exception '" + ex.getClass().getSimpleName() + "'", null));
		var fault = new GadeFault("Request failed", errs);

		ex.getFault().getDetails().forEach(fault::addDetailsItem);
		return new ResponseEntity<>(fault, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
