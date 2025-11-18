package com.gade.gps.strava.service;

import org.springframework.stereotype.Service;

import com.gade.gps.strava.config.StravaCache;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
	private static final int PAGESIZE = 200;

    final StravaCache stravaCache;
    
    public AdminServiceImpl(StravaCache stravaCache) {
    	this.stravaCache = stravaCache;
    }

    @Override
    public void archiveCachedEntries(Integer pageSize) {
    	stravaCache.archiveCachedActivities(pageSize != null ? pageSize : PAGESIZE);
	}
}
