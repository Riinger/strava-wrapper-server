package com.gade.gps.strava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class StravaApplicationRuntimeExceptionTest {

	@Test
	void testSimpleConstructor() {
		var ex = new StravaApplicationRuntimeException("testSimpleConstructor");
		assertEquals(500, ex.getHttpStatus().value());
		assertEquals("testSimpleConstructor", ex.getMessage());
	}
	@Test
	void testTwoArgConstructor() {
		var ex = new StravaApplicationRuntimeException("testTwoArgConstructor", HttpStatus.I_AM_A_TEAPOT);
		assertEquals(418, ex.getHttpStatus().value());
		assertEquals("testTwoArgConstructor", ex.getMessage());
	}

}
