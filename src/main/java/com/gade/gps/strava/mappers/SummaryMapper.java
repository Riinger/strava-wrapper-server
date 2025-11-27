package com.gade.gps.strava.mappers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.gade.gps.strava.client.model.GadeDetailedGear;
import com.gade.gps.strava.client.model.GadeSummaryActivity;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.config.StravaAppProperties;

@Component
public class SummaryMapper {

	final StravaAppProperties stravaProperties;
	
	public SummaryMapper(StravaAppProperties stravaProperties) {
        this.stravaProperties = stravaProperties;
		// Hide constructor
    }

	public GadeSummaryActivity mapToGade(SummaryActivity sa) {
		var gsa = new GadeSummaryActivity();
		
		gsa.setActivityCount(1);
		gsa.setAverageCadence(sa.getAverageCadence());
		gsa.setAverageHeartrate(sa.getAverageHeartrate());
//		gsa.setAverageWatts(sa.getAverageWatts());
		gsa.setDeviceName(sa.getDeviceName());
//		gsa.setDeviceWatts(sa.getDeviceWatts());
		gsa.setDistance(sa.getDistance());
		gsa.setElapsedTime(sa.getElapsedTime());
//		gsa.setElevHigh(sa.getElevHigh());
		gsa.setEndLatlng(sa.getEndLatlng().isEmpty() ? null : sa.getEndLatlng());
		
		var gear = new GadeDetailedGear();
		gear.setId(sa.getGearId());
		var gearData = Optional.ofNullable(stravaProperties.getGear()).map(m -> m.get(sa.getGearId())).orElse(null);
		if ( gearData != null ) {
			gear.setName(gearData.getName());
			gear.setDescription(gearData.getDescription());
		}
		gsa.setGear(gear);
		
		gsa.setId(sa.getId());
		gsa.setKilojoules(sa.getKilojoules());
		gsa.setMovingTime(sa.getMovingTime());
		gsa.setName(sa.getName());
		gsa.setSportType(sa.getSportType());
		gsa.setStartDate(sa.getStartDateLocal());
		gsa.setStartLatlng(sa.getStartLatlng().isEmpty() ? null : sa.getStartLatlng());
		gsa.setTotalElevationGain(sa.getTotalElevationGain());
		gsa.setTrainer(sa.getTrainer());
//		gsa.setWorkoutType(sa.getWorkoutType());
		
		return gsa;
	}
	public List<GadeSummaryActivity> mapToGadeList(List<SummaryActivity> saList) {
		return saList.stream().map(this::mapToGade).toList();
	}
}
