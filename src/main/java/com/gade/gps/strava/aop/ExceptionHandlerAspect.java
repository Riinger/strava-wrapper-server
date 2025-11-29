package com.gade.gps.strava.aop;

import java.util.Arrays;
import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.StravaDownstreamRuntimeException;

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
			var exception = new StravaDownstreamRuntimeException(ex.getMessage(), 
					ex.getStatusCode(), 
					Optional.ofNullable(joinPoint.getSignature()).map(Signature::getName).orElse(""));
			
			log.error("Strava call failed with HTTP Status '{}' and message '{}'", ex.getStatusCode().value(), ex.getMessage());
			if ( ex.getResponseBodyAsString() != null ) log.debug("Strava failure response = '{}'", ex.getResponseBodyAsString());
			throw exception;
		} catch (Exception ex) {
			log.error("Exception caught on {} - {} - {}", joinPoint.getSignature().getName(), ex.getMessage(), Arrays.toString(ex.getStackTrace()).replace('\r', ' '));
			throw new StravaApplicationRuntimeException(ex.getMessage());
		}
	}

}
