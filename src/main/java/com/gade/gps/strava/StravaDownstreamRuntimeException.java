package com.gade.gps.strava;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.gade.gps.strava.client.model.GadeFault;

import lombok.Data;

@Data
public class StravaDownstreamRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -2605679113205385225L;
	
	private HttpStatusCode httpStatus;
	private HttpStatusCode dsHttpStatus;
	private GadeFault fault;
	
	public StravaDownstreamRuntimeException(String message) {
		super(message);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.dsHttpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.fault = null;
	}
}
