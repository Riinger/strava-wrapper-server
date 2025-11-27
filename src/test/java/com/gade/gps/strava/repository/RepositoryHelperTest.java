package com.gade.gps.strava.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.gade.gps.strava.config.StravaAppProperties;
import com.gade.gps.strava.oauth.OAuthHelper;
import com.gade.gps.strava.utils.ResponseArchiver;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest//(classes= {StravaRepositoryImpl.class, StravaAppProperties.class, StravaWrapperApplication.class})
@ExtendWith(MockitoExtension.class)
@Slf4j
class RepositoryHelperTest {
	@MockitoBean OAuthHelper oauthHelper;
	@MockitoBean ResponseArchiver mockerArchiver;

	@Autowired StravaAppProperties stravaProperties;
	
	@Autowired RepositoryHelper helper;

	@Test
	void test_clientCreation() {
		var t = helper.getApiClient();
		assertEquals("http://localhost:12319", t.getBasePath());
	}
//	@Test
//	void test_iCreation() {
//		var t = helper.getApiClient();
//		assertEquals("http://localhost:12319", t.getBasePath());
//	}

}
