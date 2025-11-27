package com.gade.gps.strava.utils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.client.model.GadeSummaryActivity;
import com.gade.gps.strava.client.model.SummaryActivity;

public class TestHelper {
	public static GadeSummaryActivity createGadeSummaryActivity(float distance, OffsetDateTime startTime, Integer elapsedTime, Long id) {
		var gsa = new GadeSummaryActivity();
		gsa.setDistance(distance);
		gsa.setStartDate(startTime);
		gsa.setElapsedTime(elapsedTime);
		gsa.setId(id);
		return gsa;
	}
	public static List<GadeSummaryActivity> createRandomGadeSummaryActivityList(int count) {
		List<GadeSummaryActivity> summaryList = new ArrayList<>();
		for ( var i = 0 ; i < count ; i++ ) {
			summaryList.add(createRandomGadeSummaryActivity());
		}
		return summaryList;
	}	
	public static SummaryActivity createSummaryActivity(float distance, OffsetDateTime startTime, Integer elapsedTime, Long id) {
		var sa = new SummaryActivity();
		sa.setDistance(distance);
		sa.setStartDate(startTime);
		sa.setElapsedTime(elapsedTime);
		sa.setId(id);
		return sa;
	}
	public static List<SummaryActivity> createRandomSummaryActivityList(int count) {
		List<SummaryActivity> summaryList = new ArrayList<>();
		for ( var i = 0 ; i < count ; i++ ) {
			summaryList.add(createRandomSummaryActivity());
		}
		return summaryList;
	}
	public static SummaryActivity createRandomSummaryActivity() {
		var sa = new SummaryActivity();
		var avSpeed = 16.5;
		var elapsedTime = randomInt(600, 3600 * 6);
		sa.setDistance((float)(elapsedTime / 24 * avSpeed));
		sa.setStartDate(randomDate());
		sa.setElapsedTime(elapsedTime);
		sa.setId((long)randomInt(1001, 10000));
		return sa;
	}
	public static GadeSummaryActivity createRandomGadeSummaryActivity() {
		var gsa = new GadeSummaryActivity();
		var avSpeed = 16.5;
		var elapsedTime = randomInt(600, 3600 * 6);
		gsa.setDistance((float)(elapsedTime / 24 * avSpeed));
		gsa.setStartDate(randomDate());
		gsa.setElapsedTime(elapsedTime);
		gsa.setId((long)randomInt(1001, 10000));
		return gsa;
	}
	public static DetailedGear createDetailedGear(String id, String name, float distance) {
		var g = new DetailedGear();
		g.setBrandName("Brand X");
		g.setDescription("My gear for testing");
		g.setDistance(distance);
		g.setId(id);
		g.setName(name);
		return g;
	}
	public static DetailedGear createRandomDetailedGear() {
		var g = new DetailedGear();
		g.setBrandName(null);
		g.setDescription(null);
		g.setDistance((float)randomInt(1000, 100000) / 1000);
		g.setId("g" + randomInt(100000, 1000000));
		g.setName("some gear");
		return g;
	}
	private static OffsetDateTime randomDate() {
		return OffsetDateTime.of(randomInt(2022, 2025), randomInt(1, 12), randomInt(1, 28), randomInt(0, 23), randomInt(0, 59), randomInt(0, 59), randomInt(0, 999), ZoneOffset.ofHours(0));
	}
	private static int randomInt(int min, int max) {
		return new Random().nextInt(min, max);
	}
}
