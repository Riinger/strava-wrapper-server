package com.gade.gps.strava.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.StravaWrapperApplication;
import com.gade.gps.strava.config.StravaCache.CacheAction;
import com.gade.gps.strava.utils.ResponseArchiver;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes= {StravaCacheTest.class, StravaWrapperApplication.class})
@ExtendWith(MockitoExtension.class)
@Slf4j
class StravaCacheTest {
	
	private static final int ACTIVITY_COUNT = 32;

	@Autowired ObjectMapper objectMapper;
	@Autowired StravaAppProperties stravaProperties;
	@MockitoBean RestTemplate mockedRestTemplate;
	@MockitoBean ResponseArchiver mockerArchiver;
	
	@InjectMocks StravaCache cache;
	
	StravaCache spyCache;

	@PostConstruct
	void createSpy() {
		spyCache =  new StravaCache(stravaProperties, objectMapper, mockerArchiver);
	}
	@Test
	void testNullCache() {
		var spy = Mockito.spy(cache);
		Mockito.doReturn(null).when(spy).getCachedActivities();

		spy.archiveCachedActivities(12);
		verify(mockerArchiver, times(0)).archiveResponse(anyString(), anyString());
	}
	@Test
	void test_single_partial_page() {
		var pageSize = ACTIVITY_COUNT + 5;
		parameterisedTest(pageSize, Math.ceilDiv(ACTIVITY_COUNT, pageSize));
	}
	@Test
	void test_single_full_page() {
		var pageSize = ACTIVITY_COUNT;
		parameterisedTest(pageSize, Math.ceilDiv(ACTIVITY_COUNT, pageSize));
	}
	@Test
	void test_multiple_minimal_page() {
		var pageSize = ACTIVITY_COUNT - 1;
		parameterisedTest(pageSize, Math.ceilDiv(ACTIVITY_COUNT, pageSize));
	}
	@Test
	void test_multiple_partial_page() {
		var pageSize = ACTIVITY_COUNT / 2 + 2;
		parameterisedTest(pageSize, Math.ceilDiv(ACTIVITY_COUNT, pageSize));
	}
	@Test
	void test_multiple_full_page() {
		var pageSize = ACTIVITY_COUNT / 2;
		parameterisedTest(pageSize, Math.ceilDiv(ACTIVITY_COUNT, pageSize));
	}
	@Test
	void test_many_pages() {
		var pageSize = 3;
		parameterisedTest(pageSize, Math.ceilDiv(ACTIVITY_COUNT, pageSize));
	}
	@Test
	void testCacheActions() {
		assertEquals(CacheAction.NONE, CacheAction.fromValue("nOne"));
		assertEquals(CacheAction.UPDATE, CacheAction.fromValue("updAte"));
		assertEquals(CacheAction.REFRESH, CacheAction.fromValue("ReFreSH"));
		assertThrows(IllegalArgumentException.class, () -> CacheAction.fromValue("parTIal"));
	}

	private void parameterisedTest(int pageSize, int expectedPageCount) {
		// 32 activities in cache
		
		ArgumentCaptor<String> filenameCaptor = ArgumentCaptor.forClass(String.class);

		log.info("Run test case for page size {}, expected page count {}", pageSize, expectedPageCount);
		doNothing().when(mockerArchiver).archiveResponse(ArgumentMatchers.any(), ArgumentMatchers.any());
			
		spyCache.archiveCachedActivities(pageSize);
		verify(mockerArchiver, times(expectedPageCount)).archiveResponse(filenameCaptor.capture(), any()); 
		var fileIndex = 1;
		for ( var filename : filenameCaptor.getAllValues() ) {
			assertEquals(String.format("getLoggedInAthleteActivities.%03d.%03d.nnnnnnnnnnnn.nnnnnnnnnnnn", fileIndex++, pageSize), filename);
		}
	}

}
