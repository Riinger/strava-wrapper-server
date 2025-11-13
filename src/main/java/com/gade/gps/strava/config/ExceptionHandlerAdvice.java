package com.gade.gps.strava.config;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public static final ResponseEntity<Object> catchAllHandler(HttpServletRequest request, Exception ex) {
		 
		log.error("EXCEPTION caught : {} - {}", ex.getMessage(), Arrays.toString(ex.getStackTrace()));
		var url = request.getRequestURL().toString();
		var exception = createError("1", ex.getMessage(), url);
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private static com.gade.gps.strava.client.model.Error createError(String code, String msg, String url) {
		var err = new com.gade.gps.strava.client.model.Error();
		err.setCode(code);
		err.setField(msg);
		err.setResource(url);
		return err;
	}
}
