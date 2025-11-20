package com.gade.gps.strava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class StravaDownstreamRuntimeExceptionTest {

	@Test
	void testConstructor() {
		var ex = new StravaDownstreamRuntimeException("testConstructor", HttpStatus.I_AM_A_TEAPOT, "/tmp/fred");
		assertEquals(418, ex.getDsHttpStatus().value());
		assertEquals("testConstructor", ex.getMessage());
		assertEquals("/tmp/fred", ex.getResource());
	}

}
