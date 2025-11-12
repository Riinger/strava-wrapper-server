package com.gade.gps.strava.service;

import java.io.IOException;

import com.gade.gps.strava.client.model.DetailedGear;

public interface GearService {
    public DetailedGear getGearById(String gearId) throws IOException;
}
