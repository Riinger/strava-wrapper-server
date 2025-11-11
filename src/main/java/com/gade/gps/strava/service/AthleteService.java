package com.gade.gps.strava.service;

import java.io.IOException;
import java.util.List;

import com.gade.gps.strava.client.model.GadeSummaryActivity;

public interface AthleteService {
    public List<GadeSummaryActivity> getActivities(Integer before, Integer after, Integer page, Integer pageSize) throws IOException;
    public List<GadeSummaryActivity> getActivities(Boolean updateCache) throws IOException;
}
