package com.gade.gps.strava.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;

class ConvertersTest {

	@Test
	void test_headersToString() {
		var httpHeaders = new HttpHeaders();
		httpHeaders.add("header1", "value1");
		httpHeaders.add("Authorization", "my-password");
		httpHeaders.add("header1", "value2");
		httpHeaders.add("header2", "value1");
		var s = Converters.headersToString(httpHeaders);
		assertEquals("{header1=[value1, value2],header2=[value1]}", s);
	}
	@Test
	void test_empty_headersToString() {
		assertEquals("", Converters.headersToString(new HttpHeaders()));
	}
	@Test
	void test_null_headersToString() {
		assertEquals("", Converters.headersToString(null));
	}

}
