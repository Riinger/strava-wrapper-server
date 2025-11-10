package com.gade.gps.strava.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.gade.gps.strava.client.model.SummaryActivity;
import com.gade.gps.strava.oauth.StravaToken;
import com.gade.gps.strava.service.AthleteService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest//(classes= {AthleteApiController.class, StravaWrapperApplication.class})
@AutoConfigureMockMvc
@Slf4j
class AthleteApiControllerTest {
	
	@MockitoBean AthleteService service;
	@MockitoBean StravaToken token;
	
	@Autowired AthleteApiController controller;
	@Autowired MockMvc mockMvc;
	
	@Test
	void test() throws Exception {
		List<SummaryActivity>  mockedResponse = List.of(
				createSummary((float)1.23, OffsetDateTime.of(2025, 1, 31, 10, 11, 12, 345, ZoneOffset.ofHours(0)), 789, 1001L),
				createSummary((float)34.1, OffsetDateTime.of(2025, 2, 23, 18, 19, 20, 000, ZoneOffset.ofHours(0)), 1221, 1002L)
				);
				
		Mockito.when(service.getActivities(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(mockedResponse);

		this.mockMvc.perform(get("/athlete/activities").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
	}
	
	private SummaryActivity createSummary(float distance, OffsetDateTime startTime, Integer elapsedTime, Long id) {
		var sa = new SummaryActivity();
		sa.setDistance(distance);
		sa.setStartDate(startTime);
		sa.setElapsedTime(elapsedTime);
		sa.setId(id);
		return sa;
	}

}
