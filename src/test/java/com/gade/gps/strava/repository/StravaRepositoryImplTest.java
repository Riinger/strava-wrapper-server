package com.gade.gps.strava.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.client.api.ActivitiesApi;
import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.config.StravaAppProperties;
import com.gade.gps.strava.oauth.OAuthHelper;
import com.gade.gps.strava.oauth.StravaToken;
import com.gade.gps.strava.utils.TestHelper;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest//(classes= {StravaRepositoryImpl.class, StravaAppProperties.class, StravaWrapperApplication.class})
@ExtendWith(MockitoExtension.class)
@Slf4j
class StravaRepositoryImplTest {
	@MockitoBean RepositoryHelper repoHelper;
//	@MockitoBean StravaAppProperties stravaProperties;
	@MockitoBean StravaToken token;
	@MockitoBean OAuthHelper oauthHelper;

//	@Autowired RepositoryHelper repoHelper;
	@Autowired StravaAppProperties stravaProperties;
	@Autowired ObjectMapper objectMapper;
	@MockitoBean RestTemplate mockedRestTemplate;

//	@Mock ApiClient apiClient;
//	@Mock ActivitiesApi activitiesApi;
	
	@InjectMocks StravaRepositoryImpl repo;
    
	@SuppressWarnings("resource")
	@BeforeEach
    public void beforeAll() {
        MockitoAnnotations.openMocks(StravaRepositoryImplTest.class);
    }
	
	@Test
	void testInitArchive() {
		fail("Not yet implemented");
	}
	@Test
	void simpleMethod() {
		try(MockedConstruction<ActivitiesApi> mockedActivitiesApi = Mockito.mockConstruction(ActivitiesApi.class, (mock, context) ->
			when(mock.simpleMethod()).thenReturn("mocked value"))) {
				var r = repo.simple();
				log.info("Response = {}", r);
	}
//		var activitiesApi = mock(ActivitiesApi.class);
//		repo = new StravaRepositoryImpl(repoHelper, stravaProperties, objectMapper);
//		var r = repo.simple();
//		log.info("Response = {}", r);
	}
	@Test
	void gaTest() {
		// THIS WORKS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		try(MockedConstruction<ActivitiesApi> mockedActivitiesApi = Mockito.mockConstruction(ActivitiesApi.class, (mock, context) ->
			when(mock.getLoggedInAthleteActivities(any(), any(), any(), any())).thenReturn(TestHelper.createRandomSummaryActivityList(12)))) {
				when(oauthHelper.getAccessToken()).thenReturn("xxx");
				repo = new StravaRepositoryImpl(repoHelper, stravaProperties, objectMapper);
				var acts = repo.getLoggedInAthleteActivities(null,null,null,null);
				log.info("{} activities", acts.getBody().size());
				assertEquals(HttpStatus.OK, acts.getStatusCode());
	}
//		var activitiesApi = mock(ActivitiesApi.class);
//		repo = new StravaRepositoryImpl(repoHelper, stravaProperties, objectMapper);
//		var r = repo.simple();
//		log.info("Response = {}", r);
	}
	@Test
	void testGetLoggedInAthleteActivities() {
//		var apiClient = mock(ApiClient.class);
//		var activitiesApi = mock(ActivitiesApi.class);
//		when(activitiesApi.getLoggedInAthleteActivities(any(), any(), any(), any())).thenReturn(TestHelper.createRandomSummaryActivityList(2));
//		when(activitiesApi.getLoggedInAthleteActivitiesWithHttpInfo(any(), any(), any(), any())).thenReturn(ResponseEntity.ok(TestHelper.createRandomSummaryActivityList(2)));
//		when(activitiesApi.getLoggedInAthleteActivitiesWithHttpInfo(isNull(), isNull(), isNull(), isNull())).thenReturn(ResponseEntity.ok(TestHelper.createRandomSummaryActivityList(2)));
		when(oauthHelper.getAccessToken()).thenReturn("xxx");
		when(mockedRestTemplate.exchange(any(), 
				eq(new ParameterizedTypeReference<List<SummaryActivity>>() {})))
				
				.thenReturn(ResponseEntity.ok(Collections.emptyList()));
		repo = new StravaRepositoryImpl(repoHelper, stravaProperties, objectMapper);
		var acts = repo.getLoggedInAthleteActivities(null,null,null,null);
		log.info("{} activities", acts.getBody().size());
		assertEquals(HttpStatus.OK, acts.getStatusCode());
	}
//	@Test
//	void testGetLoggedInAthleteActivities2() {
//		var apiClient = new ApiClient();
//		var spyClient = spy(apiClient);
//		var r = ResponseEntity.ok(TestHelper.createRandomSummaryActivityList(2));
//		Mockito.doReturn(r).when(spyClient).invokeAPI(any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any());
////		when(helper.getApiClient()).thenReturn(apiClient);
//
////		try (var mockedApi = Mockito.mockConstruction(ActivitiesApi.class)) {
//		var api = new ActivitiesApi(spyClient);
////			when(api.getLoggedInAthleteActivities(anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(TestHelper.createRandomSummaryActivityList(2));
////			var r = TestHelper.createRandomSummaryActivityList(2);
////			when(api.getLoggedInAthleteActivities(any(), any(), any(), any())).thenReturn(r);					
////			when(api.getLoggedInAthleteActivitiesWithHttpInfo(any(), any(), any(), any())).thenReturn(ResponseEntity.ok(r));					
//			
////				(mock, context) -> {
////					when(mock.getLoggedInAthleteActivities(anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(TestHelper.createRandomSummaryActivityList(2));					
////				})) {
//			repo = new StravaRepositoryImpl(helper, stravaProperties, objectMapper);
//			var acts = repo.getLoggedInAthleteActivities(0,0,0,0);
//			log.info("{} activities", acts.getBody().size());
//			assertEquals(HttpStatus.OK, acts.getStatusCode());
////		}
//	}

	@Test
	void testGetGearById() {
		fail("Not yet implemented");
	}

}
