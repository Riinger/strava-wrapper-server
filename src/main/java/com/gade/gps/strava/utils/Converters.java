package com.gade.gps.strava.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;

public abstract class Converters {

	public static String headersToString(HttpHeaders headers) {
		if (headers == null || headers.isEmpty())
			return "";
		return headers.keySet().stream().filter(k -> !k.equalsIgnoreCase("Authorization"))
				.map(k -> k + "=" + headers.get(k)).collect(Collectors.joining(",", "{", "}"));
	}

	public static String bodyToString(InputStream body) throws IOException {
		StringBuilder builder = new StringBuilder();
		try (var bufferedReader = new BufferedReader(new InputStreamReader(body, StandardCharsets.UTF_8))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				builder.append(line).append(System.lineSeparator());
				line = bufferedReader.readLine();
			}
		}
		return builder.toString();
	}
	
	private Converters() {
		// Hide constructor
	}
}
