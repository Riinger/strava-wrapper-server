package com.gade.gps.strava.repository;

public class Dummy {
	private String d;
	
	public Dummy(String d) {
		this.d = d;
	}
	public String simpleMethod() {
		return "real " + d;
	}
}
