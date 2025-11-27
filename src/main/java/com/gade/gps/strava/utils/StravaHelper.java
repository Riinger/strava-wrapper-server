package com.gade.gps.strava.utils;

import java.util.List;

import com.gade.gps.strava.client.model.GadeError;
import com.gade.gps.strava.client.model.GadeFault;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class StravaHelper {

	public static GadeError createGadeError(String reason, String extraData) {
		return new GadeError(reason, extraData);
	}
	public static GadeFault createSimpleFault(String msg, String reason, String extraData) {
		return new GadeFault(msg, List.of(new GadeError(reason, extraData)));
	}

	private StravaHelper() {
		// Hide constructor
	}
}
