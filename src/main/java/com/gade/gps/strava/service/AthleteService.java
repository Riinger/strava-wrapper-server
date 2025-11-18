package com.gade.gps.strava.service;

import java.util.List;

import com.gade.gps.strava.client.model.GadeSummaryActivity;
import com.gade.gps.strava.config.StravaCache.CacheAction;

public interface AthleteService {
    public List<GadeSummaryActivity> getActivities(Integer before, Integer after, Integer page, Integer pageSize);
    public List<GadeSummaryActivity> getActivities(CacheAction cacheAction);
}
