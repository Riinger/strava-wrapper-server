package com.gade.gps.strava.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.model.Fault;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ExceptionHandlerAspect {
	
	@Pointcut("within(@org.springframework.stereotype.Repository *) && within(com.gade.gps.strava.repository.StravaRepositoryImpl)")
	public void stravaRepositoryPointcut() {
		// Intentionally left blank
	}
	
	@Around("stravaRepositoryPointcut()")
	public Object catchExceptionsAroundStravaRepository(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			return joinPoint.proceed();
		} catch (HttpStatusCodeException ex) {
			// Do not always log as error, it may be an acceptable HTTP status code
			if ( ex.getStatusCode().is5xxServerError() ) {
				log.error("HttpStatusCodeException caught on {} - {} - {}", joinPoint.getSignature().getName(), ex.getMessage(), Arrays.toString(ex.getStackTrace()).replace("\\n", ""));
			} else {
				log.debug("HttpStatusCodeException caught on {} - {} - {}", joinPoint.getSignature().getName(), ex.getMessage(), Arrays.toString(ex.getStackTrace()).replace("\\n", ""));
			}
			String message = ex.getMessage();
			if ( ex.getResponseBodyAsString() != null ) {
				try {
					var errorResponse = new ObjectMapper().readValue(ex.getResponseBodyAsString(), Fault.class);
					message = errorResponse.getMessage();
				} catch (Exception e) {
					; // silent ignore, use exception message
				}
			}
			throw new StravaApplicationRuntimeException(message);
		} catch (Exception ex) {
			log.error("Exception caught on {} - {} - {}", joinPoint.getSignature().getName(), ex.getMessage(), Arrays.toString(ex.getStackTrace()).replace('\r', ' '));
			throw new StravaApplicationRuntimeException(ex.getMessage());
		}
	}
}
