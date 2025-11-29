package com.gade.gps.strava.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

import com.gade.gps.strava.StravaDownstreamRuntimeException;

@SpringBootTest
class ExceptionHandlerAspectTest {
	
    @Mock private ProceedingJoinPoint joinPoint;
    @InjectMocks ExceptionHandlerAspect aspect;

	@Test
	void testHttpStatusCodeException() throws Throwable {
        when(joinPoint.proceed()).thenThrow(new HttpServerErrorException(HttpStatus.I_AM_A_TEAPOT, "unit test exception"));
        var dse = assertThrows(StravaDownstreamRuntimeException.class, () -> aspect.catchExceptionsAroundStravaRepository(joinPoint));
        verify(joinPoint, times(1)).proceed();
        assertEquals("418 unit test exception", dse.getMessage());
	}
}
