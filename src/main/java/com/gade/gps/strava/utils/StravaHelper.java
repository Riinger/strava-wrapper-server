package com.gade.gps.strava.utils;

public abstract class StravaHelper {
	public static com.gade.gps.strava.client.model.Error createError(String code, String msg, String url) {
		var err = new com.gade.gps.strava.client.model.Error();
		err.setCode(code);
		err.setField(msg);
		err.setResource(url);
		return err;
	}
	private StravaHelper() {
		// Hide constructor
	}
}
