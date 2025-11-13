package com.gade.gps.strava.config;


import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {
	public static final String CORRID_HEADER_NAME = "correlation-id";
	private static final String SEPARATOR = ",";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		var uuid = Optional.ofNullable(request.getHeader(CORRID_HEADER_NAME)).orElse(UUID.randomUUID().toString()); 
		MDC.put(CORRID_HEADER_NAME, uuid);
		var headersString = Collections.list(request.getHeaderNames()).stream()
				.map(h -> h + " : " + Collections.list(request.getHeaders(h))).collect(Collectors.joining(SEPARATOR));
		var queryParamString = request.getParameterMap().entrySet().stream().map(p -> p.getKey() + "=" + Arrays.toString(p.getValue())).collect(Collectors.joining(SEPARATOR));
		log.info("===> Processing, HTTP request : URI = '{}', Method = '{}', Headers = '{}', Query Params = '{}'", request.getRequestURI(), request.getMethod(), headersString, queryParamString);

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception exception) throws Exception {

		var headersString = response.getHeaderNames().stream()
				.map(h -> h + " : " + response.getHeader(h)).collect(Collectors.joining(SEPARATOR));
		log.info("<=== Processed, HTTP response : Headers = '{}'. HTTP status =  {}", headersString, response.getStatus());
		MDC.remove("REQID");
	}
}
