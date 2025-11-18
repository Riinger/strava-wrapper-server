package com.gade.gps.strava.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.config.StravaCache.CacheAction;
import com.gade.gps.strava.utils.StravaHelper;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
class StravaCacheTest {
	
	@AllArgsConstructor
	@Getter
	static class TestData {
		private int pageSize;
		private int expectedPages;
	}
	
	// 32 activities in cache
	private static final List<TestData> testData = List.of(
			new TestData(0, 0),
			new TestData(12, 3),
			new TestData(32, 1),
			new TestData(31, 2),
			new TestData(16, 2),
			new TestData(15, 3),
			new TestData(3, 11)
			);
	
	@Autowired ObjectMapper objectMapper;
	@Autowired StravaAppProperties stravaProperties;
	
	@InjectMocks StravaCache cache;
	
	StravaCache spyCache;

	private int fileCount = 0;

	@PostConstruct
	void createSpy() {
		spyCache =  new StravaCache(stravaProperties, objectMapper);
	}
	@Test
	void testNullCache() {
		var spy = Mockito.spy(cache);
		Mockito.doReturn(null).when(spy).getCachedActivities();

		try ( var helperMocker = mockStatic(StravaHelper.class) ) {
			helperMocker.when(() -> StravaHelper.archiveResponse(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenAnswer(Answers.RETURNS_DEFAULTS); 
			spy.archiveCachedActivities(12);
			helperMocker.verify(() -> StravaHelper.archiveResponse(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString()), times(0));
		}		
	}
	@Test
	void testListOfScenarios() {
		for ( var td : testData ) {
			try ( var helperMocker = mockStatic(StravaHelper.class) ) {
				helperMocker.when(() -> StravaHelper.archiveResponse(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenAnswer((Answer<Void>) inv -> {
					fileCount++;
					assertEquals(String.format("getLoggedInAthleteActivities.%03d.%04d", fileCount, td.pageSize), inv.getArgument(0)); 
					log.info("Test : Archive file name matches {}", inv.getArgument(0).toString());
					return (Void)null;
				});
				spyCache.archiveCachedActivities(td.pageSize);
				assertEquals(td.expectedPages, fileCount);
				fileCount = 0;
			}
		}
	}
	@Test
	void testCacheActions() {
		assertEquals(CacheAction.NONE, CacheAction.fromValue("nOne"));
		assertEquals(CacheAction.UPDATE, CacheAction.fromValue("updAte"));
		assertEquals(CacheAction.REFRESH, CacheAction.fromValue("ReFreSH"));
		assertThrows(IllegalArgumentException.class, () -> CacheAction.fromValue("parTIal"));
	}
}
