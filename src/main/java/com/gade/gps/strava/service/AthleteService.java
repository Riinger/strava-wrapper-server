package com.gade.gps.strava.service;

import java.io.IOException;
import java.util.List;

import com.gade.gps.strava.client.model.SummaryActivity;

public interface AthleteService {
    public List<SummaryActivity> getActivities(Integer before, Integer after, Integer page, Integer pageSize) throws IOException;
}
