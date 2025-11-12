package com.gade.gps.strava.mappers;

import java.util.List;

import com.gade.gps.strava.client.model.GadeSummaryActivity;
import com.gade.gps.strava.client.model.SummaryActivity;

public abstract class SummaryMapper {

	public static GadeSummaryActivity mapToGade(SummaryActivity sa) {
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
		gsa.setGear(sa.getGearId());
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
	public static List<GadeSummaryActivity> mapToGadeList(List<SummaryActivity> saList) {
		return saList.stream().map(sa -> mapToGade(sa)).toList();
	}
	
}
