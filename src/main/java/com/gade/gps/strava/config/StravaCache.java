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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gade.gps.strava.client.model.SummaryActivity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StravaCache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Value("${strava.cache.path}")
	private String cacheFilePath;

	private String getCacheFile() {
		return cacheFilePath;
	}

	@SuppressWarnings("unchecked")
	public List<SummaryActivity> getCachedActivities()
	{
		List<SummaryActivity> result = null;

	      try (FileInputStream fileIn = new FileInputStream(getCacheFile());
				ObjectInputStream in = new ObjectInputStream(fileIn))
	      {
	         result = (List<SummaryActivity>) in.readObject();
	         log.info("Data successfully read from cache");
	      }
	      catch ( Exception  e )
	      {
	         log.warn("Error reading cache, will refresh data. Error [{}]", e.getMessage());
	         result = new ArrayList<>();
	      }
		return result;
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
		String cacheFile = getCacheFile();
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
