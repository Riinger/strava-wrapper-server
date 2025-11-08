package com.gade.gps.strava.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class GenericObjectList<T> {
	
	private String cacheFilePath;
	private ArrayList<T> theList;
	
	public GenericObjectList(String cacheFilePath) {
		this.cacheFilePath = cacheFilePath;
		theList = new ArrayList<T>();
	}
	public List<T> getData() {
		return this.theList;
	}
	
	// Save - write object to cache file
	// Load - load object from cache file

	public void save() throws IOException {
		try (FileOutputStream fileOut = new FileOutputStream(cacheFilePath) ; ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(this.theList);
		}
		log.debug("Serialized data is saved in {}", cacheFilePath);
	}
	@SuppressWarnings("unchecked")
	public void load() throws IOException, ClassNotFoundException {
		if ( (new File(cacheFilePath)).exists() ) {
			try (FileInputStream fileIn = new FileInputStream(cacheFilePath); ObjectInputStream in = new ObjectInputStream(fileIn)) {
				this.theList.addAll((ArrayList<T>)in.readObject());
			}
			log.debug("Data successfully read from cache");
		} else {
			log.debug("Cache file does not exist");
			this.theList.clear();
		}
	}
}
