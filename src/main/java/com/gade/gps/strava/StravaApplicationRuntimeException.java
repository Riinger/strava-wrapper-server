package com.gade.gps.strava;

import org.springframework.http.HttpStatus;

public class StravaApplicationRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -2605679113205385225L;
	
	private final HttpStatus httpStatus;
	
	public StravaApplicationRuntimeException(String message) {
		super(message);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	public StravaApplicationRuntimeException(String message, HttpStatus statusCode) {
		super(message);
		this.httpStatus = statusCode;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
