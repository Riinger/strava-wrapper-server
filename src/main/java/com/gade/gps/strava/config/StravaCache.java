package com.gade.gps.strava.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.service.AthleteService;
import com.gade.gps.strava.utils.Archiver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StravaCache implements Serializable {
	private static final long serialVersionUID = 1L;
	

	public enum CacheAction {
		NONE,
		UPDATE,
		REFRESH;

		public static CacheAction fromValue(String value) {
			for ( var op : CacheAction.values() ) {
				if ( op.toString().equalsIgnoreCase(value) ) return op;
			}
			throw new IllegalArgumentException("Unknown cache operation '" + value + "'");
		}
	}

	private transient StravaAppProperties stravaProperties;
	final ObjectMapper objectMapper;
	private transient Archiver archiver;


    StravaCache(StravaAppProperties stravaProperties, ObjectMapper objectMapper, Archiver archiver) {
        this.stravaProperties = stravaProperties;
        this.objectMapper = objectMapper;
		this.archiver = archiver;
    }

	@SuppressWarnings("unchecked")
	public List<SummaryActivity> getCachedActivities()
	{
		List<SummaryActivity> result = null;

		try (FileInputStream fileIn = new FileInputStream(stravaProperties.getCache().getPath());
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			result = (List<SummaryActivity>) in.readObject();
			log.info("Data successfully read from cache");
		} catch (Exception e) {
			log.warn("Error reading cache, will refresh data. Error [{}]", e.getMessage());
			result = new ArrayList<>();
		}
		return result;
	}
	public void archiveCachedActivities(Integer pageSize) {
		var activities = getCachedActivities();
		log.debug("cachedActivities returns {}", activities == null ? "null" : "non-null");
		log.debug("cached activity count {}", activities == null ? "n/a" : activities.size());
		if ( activities == null || pageSize < 1 ) return;
		log.info("Archiving {} cached activities", activities.size());
		
		var page = 1;
		
		for ( var startIndex = 0 ; startIndex < activities.size() ; startIndex += pageSize, page++ ) {
			var thisPageSize = activities.size() - startIndex >= pageSize ? pageSize : activities.size() - startIndex;
			log.debug("SubList for page {} has {} items from start index {}", page, thisPageSize, startIndex);
			log.debug("Get sublist from {} to {}", startIndex, startIndex + thisPageSize);
			var subList = activities.subList(startIndex, startIndex + thisPageSize);
		
			try {
				log.debug("sublist = {} -> {}", objectMapper.writeValueAsString(subList));
				archiver.archiveResponse(AthleteService.getActivitiesArchiveFilename(page, pageSize, null, null), objectMapper.writeValueAsString(subList));
			} catch (JsonProcessingException e) {
				log.error("Unable to convert response to string - {}", e.getMessage());
				throw new StravaApplicationRuntimeException(e.getMessage());
			}
		}
	}
	public static SummaryActivity getLatestActivity(final List<SummaryActivity> activities) {
		SummaryActivity latestActivity = null;
		if (activities != null) {
			for (var act : activities) {
				if (latestActivity != null) {
					if (act.getStartDate().isAfter(latestActivity.getStartDate())) {
						latestActivity = act;
					}
				} else {
					latestActivity = act;
				}
			}
		}
		return latestActivity;
	}

	public void update(List<SummaryActivity> body) {
		String cacheFile = stravaProperties.getCache().getPath();
		try (FileOutputStream fileOut = new FileOutputStream(cacheFile);
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(body);
			log.debug("Serialized data is saved in " + cacheFile);
		} catch (NotSerializableException nse) {
			nse.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}


}
