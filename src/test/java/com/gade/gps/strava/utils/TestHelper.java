package com.gade.gps.strava.utils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.gade.gps.strava.client.model.SummaryActivity;

public class TestHelper {
	public static SummaryActivity createSummary(float distance, OffsetDateTime startTime, Integer elapsedTime, Long id) {
		var sa = new SummaryActivity();
		sa.setDistance(distance);
		sa.setStartDate(startTime);
		sa.setElapsedTime(elapsedTime);
		sa.setId(id);
		return sa;
	}
	public static List<SummaryActivity> createSummaryList(int count) {
		List<SummaryActivity> summaryList = new ArrayList<>();
		for ( var i = 0 ; i < count ; i++ ) {
			summaryList.add(createRandoSummaryActivity());
		}
		return summaryList;
	}
	public static SummaryActivity createRandoSummaryActivity() {
		var sa = new SummaryActivity();
		var avSpeed = 16.5;
		var elapsedTime = randomInt(600, 3600 * 6);
		sa.setDistance((float)(elapsedTime / 24 * avSpeed));
		sa.setStartDate(randomDate());
		sa.setElapsedTime(elapsedTime);
		sa.setId((long)randomInt(1001, 10000));
		return sa;
	}
	private static OffsetDateTime randomDate() {
		return OffsetDateTime.of(randomInt(2022, 2025), randomInt(1, 12), randomInt(1, 28), randomInt(0, 23), randomInt(0, 59), randomInt(0, 59), randomInt(0, 999), ZoneOffset.ofHours(0));
	}
	private static int randomInt(int min, int max) {
		return min + (int)(Math.random() * (max - min));
	}
}
