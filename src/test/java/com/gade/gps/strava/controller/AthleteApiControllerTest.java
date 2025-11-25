package com.gade.gps.strava.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.gade.gps.strava.client.model.GadeSummaryActivity;
import com.gade.gps.strava.service.AthleteService;
import com.gade.gps.strava.utils.TestHelper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest//(classes= {AthleteApiController.class, StravaWrapperApplication.class})
@AutoConfigureMockMvc
@Slf4j

@ExtendWith(MockitoExtension.class)
class AthleteApiControllerTest {
	
	@MockitoBean AthleteService service;
	@MockitoBean RestTemplate mockedRestTemplate;
	
	@Autowired AthleteApiController controller;
	@Autowired MockMvc mockMvc;
	
	@Test
	void test() throws Exception {
		List<GadeSummaryActivity>  mockedResponse = List.of(
				TestHelper.createGadeSummaryActivity((float)1.23, OffsetDateTime.of(2025, 1, 31, 10, 11, 12, 345, ZoneOffset.ofHours(0)), 789, 1001L),
				TestHelper.createGadeSummaryActivity((float)34.1, OffsetDateTime.of(2025, 2, 23, 18, 19, 20, 000, ZoneOffset.ofHours(0)), 1221, 1002L)
				);
				
		Mockito.when(service.getActivities(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(mockedResponse);

		mockMvc.perform(get("/athlete/activities").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
	}
}
