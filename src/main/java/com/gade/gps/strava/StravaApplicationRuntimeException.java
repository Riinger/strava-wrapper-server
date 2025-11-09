package com.gade.gps.strava;

public class StravaApplicationRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -2605679113205385225L;
	public StravaApplicationRuntimeException(String message) {
		super(message);
	}
}
