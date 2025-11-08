package com.gade.gps.strava.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class SimpleObjectList {
	private static final String CACHE_FILE = "d:\\cache\\cachefile";
	
	ArrayList<SimpleObject> theData;
	
	public SimpleObjectList() {
		theData = new ArrayList<>();
	}
	public void add(SimpleObject so) {
		theData.add(so);
	}
	
	// Save - write object to cache file
	// Load - load object from cache file

	public void save() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.writeValue(new File(CACHE_FILE), this.theData);
	}
	@SuppressWarnings("unchecked")
	public void load() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		
		this.theData = mapper.readValue(new File(CACHE_FILE), ArrayList.class);
	}
}
