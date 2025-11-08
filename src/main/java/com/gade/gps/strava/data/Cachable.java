package com.gade.gps.strava.data;

public interface Cachable {

	public Object load();
	public void save();
}
