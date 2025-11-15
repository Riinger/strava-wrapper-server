package com.gade.gps.strava;

import org.springframework.http.HttpStatusCode;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper=false)
@Getter
public class StravaDownstreamRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -2605679113205385225L;
	
	private final HttpStatusCode dsHttpStatus;
	private final String resource;
	
	public StravaDownstreamRuntimeException(String message, HttpStatusCode dsStatusCode, String resource) {
		super(message);
		this.dsHttpStatus = dsStatusCode;
		this.resource = resource;
	}
}
