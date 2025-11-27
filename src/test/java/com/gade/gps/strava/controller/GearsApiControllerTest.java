package com.gade.gps.strava.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.client.model.DetailedGear;
import com.gade.gps.strava.service.GearService;
import com.gade.gps.strava.utils.TestHelper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@ExtendWith(MockitoExtension.class)
class GearsApiControllerTest {
		
	@MockitoBean GearService service;
	@MockitoBean RestTemplate mockedRestTemplate;
	
	@Autowired GearsApiController controller;
	@Autowired MockMvc mockMvc;
	@Autowired ObjectMapper objectMapper;
	
	@Test
	void test() throws Exception {
		var  mockedResponse = TestHelper.createDetailedGear("g100101", "shiny kit", (float)1.23);
		Mockito.when(service.getGearById(ArgumentMatchers.any())).thenReturn(mockedResponse);
		var result = mockMvc.perform(get("/gear/g100101").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		assertEquals(200, result.getResponse().getStatus());
		var gearDetails = objectMapper.readValue(result.getResponse().getContentAsString(), DetailedGear.class);
		assertAll(
			() -> assertEquals(mockedResponse.getName(), gearDetails.getName()),
			() -> assertEquals(mockedResponse.getBrandName(), gearDetails.getBrandName()),
			() -> assertEquals(mockedResponse.getDistance(), gearDetails.getDistance())
		);
	}
}