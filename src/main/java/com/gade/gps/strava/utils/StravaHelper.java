package com.gade.gps.strava.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.gade.gps.strava.client.model.GadeError;
import com.gade.gps.strava.client.model.GadeFault;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class StravaHelper {
	private static final String ARCHIVE_FILE_EXT = ".arc"; 

	public static GadeError createGadeError(String reason, String extraData) {
		return new GadeError(reason, extraData);
	}
	public static GadeFault createSimpleFault(String msg, String reason, String extraData) {
		return new GadeFault(msg, List.of(new GadeError(reason, extraData)));
	}
    public static void archiveResponse(String filename, String content, String archiveDirectory) {
		// Write response to <page>.<lastActivityDate>.arc
		var archivePath = Paths.get(archiveDirectory, filename + ARCHIVE_FILE_EXT);
		log.info("Archive to file {}", archivePath.toString());
		try {
			Files.write(archivePath, content.getBytes());
		} catch(IOException ioe) {
			log.warn("Unable to create archive file - {}", ioe.getMessage());
		}
    }

	private StravaHelper() {
		// Hide constructor
	}
}
