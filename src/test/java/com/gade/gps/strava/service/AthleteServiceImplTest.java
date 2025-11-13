package com.gade.gps.strava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.gade.gps.strava.config.StravaCache;
import com.gade.gps.strava.repository.StravaRepository;
import com.gade.gps.strava.utils.TestHelper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest//(classes= {AthleteServiceImpl.class, StravaWrapperApplication.class})
//@AutoConfigureMockMvc
@Slf4j
class AthleteServiceImplTest {
	@Autowired AthleteService service;
	
	@MockitoBean StravaRepository stravaRepository;
	@MockitoBean StravaCache stravaCache;

	@Test
	void test_getLoggedInAthleteActivities() {
		var mockedResponseEntity = ResponseEntity.ok(TestHelper.createRandomSummaryActivityList(2));
		Mockito.when(stravaRepository.getLoggedInAthleteActivities(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(mockedResponseEntity);

		var response = service.getActivities(null, null, null, null);
		assertEquals(2, response.size());
	}
	@Test
	void test_cachedActivities() {
		var mockedCacheResponse = TestHelper.createRandomSummaryActivityList(1);
		var mockedResponseEntity = ResponseEntity.ok(TestHelper.createRandomSummaryActivityList(3));
		Mockito.when(stravaRepository.getLoggedInAthleteActivities(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(mockedResponseEntity);
		Mockito.when(stravaCache.getCachedActivities()).thenReturn(mockedCacheResponse);

		var response = service.getActivities(null);
		assertEquals(4, response.size());
	}
}
