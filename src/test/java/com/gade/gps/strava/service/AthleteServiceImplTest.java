package com.gade.gps.strava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gade.gps.strava.config.StravaCache;
import com.gade.gps.strava.config.StravaCache.CacheAction;
import com.gade.gps.strava.repository.StravaRepository;
import com.gade.gps.strava.utils.TestHelper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest//(classes= {AthleteServiceImpl.class, StravaWrapperApplication.class})
@ExtendWith(MockitoExtension.class)
@Slf4j

class AthleteServiceImplTest {
	@Autowired AthleteService service;
	
	@MockitoBean StravaRepository stravaRepository;
	@MockitoBean StravaCache stravaCache;
	@MockitoBean RestTemplate mockedRestTemplate;

	@Test
	void test_getLoggedInAthleteActivities() throws JsonProcessingException {
		var mockedResponseEntity = ResponseEntity.ok(TestHelper.createRandomSummaryActivityList(2));
		Mockito.when(stravaRepository.getLoggedInAthleteActivities(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(mockedResponseEntity);

		var response = service.getActivities(null, null, null, null);
		assertEquals(2, response.size());
	}
	@Test
	void test_cachedActivities() throws JsonProcessingException  {
		var mockedCacheResponse = TestHelper.createRandomSummaryActivityList(1);
		var mockedResponseEntity = ResponseEntity.ok(TestHelper.createRandomSummaryActivityList(3));
		Mockito.when(stravaRepository.getLoggedInAthleteActivities(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(mockedResponseEntity);
		Mockito.when(stravaCache.getCachedActivities()).thenReturn(mockedCacheResponse);

		var response = service.getActivities(CacheAction.UPDATE);
		assertEquals(4, response.size());
	}
	@Test
	void test_archiveFilenames() {
		final String baseName = "getLoggedInAthleteActivities";
		record TestData (Integer page, Integer pageSize, Integer after, Integer before, String expectedSuffix) {}
		var testCases = new TestData[] {
				new TestData(null, null, null, null, ".nnn.nnn.nnnnnnnnnnnn.nnnnnnnnnnnn"),
				new TestData(1, null, null, null, ".001.nnn.nnnnnnnnnnnn.nnnnnnnnnnnn"),
				new TestData(null, 10, null, null, ".nnn.010.nnnnnnnnnnnn.nnnnnnnnnnnn"),
				new TestData(null, null, 100, null, ".nnn.nnn.000000000100.nnnnnnnnnnnn"),
				new TestData(null, null, null, 2000, ".nnn.nnn.nnnnnnnnnnnn.000000002000"),
				new TestData(1, null, 123, null, ".001.nnn.000000000123.nnnnnnnnnnnn"),
				new TestData(1, null, null, 2345, ".001.nnn.nnnnnnnnnnnn.000000002345"),
				new TestData(1, 20, null, 2345, ".001.020.nnnnnnnnnnnn.000000002345"),
				new TestData(null, 20, null, 2345, ".nnn.020.nnnnnnnnnnnn.000000002345"),
				new TestData(null, null, 300, 2345, ".nnn.nnn.000000000300.000000002345"),
				new TestData(1, 20, 789, 2345, ".001.020.000000000789.000000002345"),
		};
		
		for ( var tc : testCases ) {
			assertEquals(baseName + tc.expectedSuffix(), AthleteService.getActivitiesArchiveFilename(tc.page, tc.pageSize, tc.after, tc.before));			
		}
	}
}
