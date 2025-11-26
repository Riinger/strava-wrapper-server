package com.gade.gps.strava.repository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest//(classes= {StravaRepositoryImpl.class, StravaAppProperties.class, StravaWrapperApplication.class})
@ExtendWith(MockitoExtension.class)
@Slf4j
class StravaRepositoryImpl2Test {

	@InjectMocks StravaRepositoryImpl2 repo;
    
	@SuppressWarnings("resource")
	@BeforeEach
    public void beforeAll() {
        MockitoAnnotations.openMocks(StravaRepositoryImpl2Test.class);
    }
	
	@Test
	void simpleMethod() {
		try(MockedConstruction<Dummy> mockedDummy = Mockito.mockConstruction(Dummy.class, (mock, context) ->
			
			when(mock.simpleMethod()).thenReturn("mocked value"))) {
			var r = repo.simple();
			log.info("Response = {}", r);
		}
//		var dummy = mock(Dummy.class);
//		when(dummy.simpleMethod()).thenReturn("mocked value");
////		repo = new StravaRepositoryImpl2(stravaProperties);
//		var r = repo.simple();
//		log.info("Response = {}", r);
	}
}
