package com.gade.gps.strava.aop;

import java.util.Arrays;
import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.client.model.Fault;
import com.gade.gps.strava.utils.StravaHelper;

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
//			if (ex instanceof HttpServerErrorException serr) {
			var cause = Optional.ofNullable(ex.getMostSpecificCause()).map(t -> "mostSpecificCause - " + t.getMessage()).orElse(
					Optional.ofNullable(ex.getRootCause()).map(t -> "rootCause - " + t.getMessage()).orElse(
						Optional.ofNullable(ex.getCause()).map(t -> "cause - " + t.getMessage()).orElse(null)));

//				var c = serr.getCause() != null ? serr.getCause().getMessage() : "null";
//				var msc = serr.getMostSpecificCause() != null ? serr.getMostSpecificCause().getMessage() : "null";
//				var rc = serr.getRootCause() != null ? serr.getRootCause().getMessage() : "null";
//				log.info("SERVER exception cause '{}', root cause '{}', most specific cause '{}'", c, rc, msc);
//				log.info("Exception '{}'", cause);
//			} else if (ex instanceof HttpClientErrorException cerr) {
//				var c = cerr.getCause() != null ? cerr.getCause().getMessage() : "null";
//				var msc = cerr.getMostSpecificCause() != null ? cerr.getMostSpecificCause().getMessage() : "null";
//				var rc = cerr.getRootCause() != null ? cerr.getRootCause().getMessage() : "null";
//				log.info("CLIENT exception cause '{}', root cause '{}', most specific cause '{}'", c, rc, msc);
//			}
			log.info("XXXXXXX {}", ex.getMessage());
			var message = cause != null ? cause : ex.getMessage();
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
