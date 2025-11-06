package com.gade.gps.strava.server.config;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gade.gps.strava.server.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public static final ResponseEntity<Object> catchAllHandler(Exception ex, WebRequest request) {
		log.error("EXCEPTION caught : {} - {}", ex.getMessage(), Arrays.toString(ex.getStackTrace()));
		var exception = createError(String.format("An exception was caught : '%s'", ex.getMessage()));
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private static Object createError(String msg) {
		return new ErrorResponse(msg);
	}
}
