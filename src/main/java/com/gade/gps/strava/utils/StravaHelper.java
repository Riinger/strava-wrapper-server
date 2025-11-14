package com.gade.gps.strava.utils;

import com.gade.gps.strava.client.model.GadeError;

public abstract class StravaHelper {
	public static GadeError createError(String code, String msg, String url) {
		var err = new GadeError();
		err.setCode(code);
		err.setField(msg);
		err.setResource(url);
		return err;
	}
	private StravaHelper() {
		// Hide constructor
	}
}
