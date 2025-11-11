package com.gade.gps.strava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestClientException;

import com.gade.gps.strava.StravaWrapperApplication;
import com.gade.gps.strava.client.model.SummaryActivity;
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
	void test_getLoggedInAthleteActivities() throws RestClientException, IOException {
		List<SummaryActivity>  mockedResponse = List.of(
				TestHelper.createSummary((float)1.23, OffsetDateTime.of(2025, 1, 31, 10, 11, 12, 345, ZoneOffset.ofHours(0)), 789, 1001L),
				TestHelper.createSummary((float)34.1, OffsetDateTime.of(2025, 2, 23, 18, 19, 20, 000, ZoneOffset.ofHours(0)), 1221, 1002L)
				);
		var mockedResponseEntity = ResponseEntity.ok(mockedResponse); 
		Mockito.when(stravaRepository.getLoggedInAthleteActivities(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(mockedResponseEntity);

		var response = service.getActivities(null, null, null, null);
		assertEquals(2, response.size());
	}
	@Test
	void test_cachedActivities() throws RestClientException, IOException {
		var mockedRepositoryResponse = TestHelper.createSummaryList(3);
//		List<SummaryActivity>  mockedRepositoryResponse = List.of(
//				TestHelper.createSummary((float)1.23, OffsetDateTime.of(2025, 1, 31, 10, 11, 12, 345, ZoneOffset.ofHours(0)), 789, 1001L),
//				TestHelper.createSummary((float)4.23, OffsetDateTime.of(2025, 3, 31, 1, 2, 3, 456, ZoneOffset.ofHours(0)), 543, 2001L),
//				TestHelper.createSummary((float)34.1, OffsetDateTime.of(2025, 2, 23, 18, 19, 20, 000, ZoneOffset.ofHours(0)), 1221, 1002L)
//				);
		var mockedCacheResponse = TestHelper.createSummaryList(1);
//		List<SummaryActivity>  mockedCacheResponse = List.of(
//				TestHelper.createSummary((float)0.1, OffsetDateTime.of(2024, 7, 5, 1, 11, 22, 555, ZoneOffset.ofHours(0)), 102, 3001L)
//				);
		var mockedResponseEntity = ResponseEntity.ok(mockedRepositoryResponse);
		Mockito.when(stravaRepository.getLoggedInAthleteActivities(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(mockedResponseEntity);
		Mockito.when(stravaCache.getCachedActivities()).thenReturn(mockedCacheResponse);

		var response = service.getActivities();
		assertEquals(4, response.size());
	}
}
