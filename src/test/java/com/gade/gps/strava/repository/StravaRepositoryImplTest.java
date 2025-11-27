package com.gade.gps.strava.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.client.api.ActivitiesApi;
import com.gade.gps.strava.client.api.GearsApi;
import com.gade.gps.strava.config.StravaAppProperties;
import com.gade.gps.strava.oauth.OAuthHelper;
import com.gade.gps.strava.oauth.StravaToken;
import com.gade.gps.strava.utils.ResponseArchiver;
import com.gade.gps.strava.utils.TestHelper;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest//(classes= {StravaRepositoryImpl.class, StravaAppProperties.class, StravaWrapperApplication.class})
@ExtendWith(MockitoExtension.class)
@Slf4j
class StravaRepositoryImplTest {
	@MockitoBean RepositoryHelper repoHelper;
	@MockitoBean StravaToken token;
	@MockitoBean OAuthHelper oauthHelper;
	@MockitoBean ResponseArchiver mockerArchiver;

	@Autowired StravaAppProperties stravaProperties;
	@Autowired ObjectMapper objectMapper;
	@MockitoBean RestTemplate mockedRestTemplate;
	
	@InjectMocks StravaRepositoryImpl repo;
    
	@SuppressWarnings("resource")
	@BeforeEach
    void beforeAll() {
        MockitoAnnotations.openMocks(StravaRepositoryImplTest.class);
    }
	
	@Test
	void testGetLoggedInAthleteActivities() throws JsonProcessingException {
		try(MockedConstruction<ActivitiesApi> mockedActivitiesApi = Mockito.mockConstruction(ActivitiesApi.class, (mock, context) ->
			when(mock.getLoggedInAthleteActivities(any(), any(), any(), any())).thenReturn(TestHelper.createRandomSummaryActivityList(12)))) {
				when(oauthHelper.getAccessToken()).thenReturn("xxx");
				repo = new StravaRepositoryImpl(repoHelper, objectMapper, mockerArchiver);
				var acts = repo.getLoggedInAthleteActivities(null,null,null,null);
				assertEquals(12, acts.getBody().size());
				assertEquals(HttpStatus.OK, acts.getStatusCode());
		}
	}

	@Test
	void testGetGearById() throws JsonProcessingException {
		try(MockedConstruction<GearsApi> mockedGearsApi = Mockito.mockConstruction(GearsApi.class, (mock, context) ->
		when(mock.getGearById(any())).thenReturn(TestHelper.createRandomDetailedGear()))) {
			when(oauthHelper.getAccessToken()).thenReturn("xxx");
			repo = new StravaRepositoryImpl(repoHelper, objectMapper, mockerArchiver);
			var g = repo.getGearById("id12");
			assertEquals("some gear", g.getBody().getName());
			assertEquals(HttpStatus.OK, g.getStatusCode());
		}
	}
	@Test
	void testGetLoggedInAthleteActivitiesArchive() throws JsonProcessingException {
	    stravaProperties.getArchive().setEnabled(true);
		try(MockedConstruction<ActivitiesApi> mockedActivitiesApi = Mockito.mockConstruction(ActivitiesApi.class, (mock, context) ->
			when(mock.getLoggedInAthleteActivities(any(), any(), any(), any())).thenReturn(TestHelper.createRandomSummaryActivityList(12)))) {
				when(oauthHelper.getAccessToken()).thenReturn("xxx");
				repo = new StravaRepositoryImpl(repoHelper, objectMapper, mockerArchiver);
				var acts = repo.getLoggedInAthleteActivities(null,null,null,null);
				assertEquals(12, acts.getBody().size());
				assertEquals(HttpStatus.OK, acts.getStatusCode());
		}
	}

}
