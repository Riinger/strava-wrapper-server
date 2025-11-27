package com.gade.gps.strava.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gade.gps.strava.client.model.DetailedGear;

public interface GearService {
    public DetailedGear getGearById(String gearId) throws JsonProcessingException;
}
