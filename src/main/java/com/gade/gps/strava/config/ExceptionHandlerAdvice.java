package com.gade.gps.strava.config;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gade.gps.strava.utils.StravaHelper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public static final ResponseEntity<Object> catchAllHandler(HttpServletRequest request, Exception ex) {
		 
		log.error("EXCEPTION caught : {} - {}", ex.getMessage(), Arrays.toString(ex.getStackTrace()));
		var url = request.getRequestURL().toString();
		var exception = StravaHelper.createError("1", ex.getMessage(), url);
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
