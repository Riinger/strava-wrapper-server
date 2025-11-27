package com.gade.gps.strava.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

import com.gade.gps.strava.config.StravaAppProperties;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ResponseArchiver implements Archiver {
	private static final String ARCHIVE_FILE_EXT = ".arc";
	
	final StravaAppProperties stravaProperties; 

    public ResponseArchiver(StravaAppProperties stravaProperties) {
		this.stravaProperties = stravaProperties;
	}
    @PostConstruct
    void initArchive() {
		var arcDir = new File(stravaProperties.getArchive().getDirectory());
		log.info("Create archive directory result {}", arcDir.mkdirs());
    }

    @Override
	public void archiveResponse(String filename, String content) {
		if ( Boolean.TRUE.equals(stravaProperties.getArchive().getEnabled()) ) {
			var archivePath = Paths.get(stravaProperties.getArchive().getDirectory(), filename + ARCHIVE_FILE_EXT);
			log.info("Archive to file {}", archivePath.toString());
			try {
				Files.write(archivePath, content.getBytes());
			} catch(IOException ioe) {
				log.warn("Unable to create archive file - {}", ioe.getMessage());
			}
    	}
    }

}
