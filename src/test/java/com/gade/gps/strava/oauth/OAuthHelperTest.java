package com.gade.gps.strava.oauth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gade.gps.strava.StravaApplicationRuntimeException;
import com.gade.gps.strava.StravaWrapperApplication;
import com.gade.gps.strava.config.StravaAppProperties;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes= {OAuthHelper.class, StravaAppProperties.class, StravaWrapperApplication.class})//RestTemplate.class})
@ExtendWith(MockitoExtension.class)
@Slf4j
class OAuthHelperTest {
	
	@Autowired StravaAppProperties stravaProperties;
	StravaToken token;
	@MockitoBean StravaToken newToken;
	@MockitoBean RestTemplate mockedRestTemplate;
	
	@InjectMocks OAuthHelper helper;

    @SuppressWarnings("resource")
	@BeforeEach
    void beforeAll() {
        MockitoAnnotations.openMocks(OAuthHelperTest.class);
    }

	@Test
	void testGetAccessTokenAfterExpiry() throws IOException {
		newToken = createNewMockedToken();
		var mockedResponse = ResponseEntity.ok(new ObjectMapper().writeValueAsString(newToken));
		when(mockedRestTemplate.postForEntity(anyString(), any(), eq(String.class)))
			.thenReturn(mockedResponse);
		token = createToken(1212121212L);
		helper = new OAuthHelper(stravaProperties, token, mockedRestTemplate);
		
		// For testing...do not overwrite token file, so replace filename with temp file
		var tmpTokenFile = File.createTempFile("updated-test-token.", ".properties", new File("src/test/resources"));
		tmpTokenFile.deleteOnExit();
		stravaProperties.getAuth().setAuthFile(tmpTokenFile.getAbsolutePath());
		
		var at = helper.getAccessToken();
		assertEquals("new-test-access-token", at);
	}
	@Test
	void testGetAccessTokenBeforeExpiry() {
		token = createToken(242424242424L);
		helper = new OAuthHelper(stravaProperties, token, mockedRestTemplate);
		var at = helper.getAccessToken();
		assertEquals("test-access-token", at);
	}
	@Test
	void testInvalidNewAccessTokenNotJson() {
		var mockedResponse = ResponseEntity.ok("Not JSON");
		when(mockedRestTemplate.postForEntity(anyString(), any(), eq(String.class)))
			.thenReturn(mockedResponse);
		token = createToken(1212121212L);
		helper = new OAuthHelper(stravaProperties, token, mockedRestTemplate);
		
		var sare = assertThrows(StravaApplicationRuntimeException.class, () -> helper.getAccessToken());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, sare.getHttpStatus());
		assertTrue(sare.getMessage().startsWith("Access Token error : JsonParseException"));
	}
	@Test
	void testInvalidNewAccessToken() {
		var mockedResponse = ResponseEntity.ok("{ \"token\":\"fred\"}");
		when(mockedRestTemplate.postForEntity(anyString(), any(), eq(String.class)))
			.thenReturn(mockedResponse);
		token = createToken(1212121212L);
		helper = new OAuthHelper(stravaProperties, token, mockedRestTemplate);
		
		var sare = assertThrows(StravaApplicationRuntimeException.class, () -> helper.getAccessToken());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, sare.getHttpStatus());
		assertTrue(sare.getMessage().startsWith("Access Token error : UnrecognizedPropertyException"));
	}

	private StravaToken createToken(long expiresAt) {
		var stoken = new StravaToken();
		stoken.setAccessToken("test-access-token");
		stoken.setExpiresAt(expiresAt);
		stoken.setExpiresIn(12L);
		stoken.setRefreshToken("test-refresh-token");
		stoken.setTokenType("test-type");
		stoken.setStravaProperties(stravaProperties);
		return stoken;
	}
	private StravaToken createNewMockedToken() {
		newToken = mock(StravaToken.class);
		when(newToken.getAccessToken()).thenReturn("new-test-access-token");
		when(newToken.getExpiresAt()).thenReturn(2323232323L);
		when(newToken.getExpiresIn()).thenReturn(23L);
		when(newToken.getRefreshToken()).thenReturn("new-test-refresh-token");
		when(newToken.getTokenType()).thenReturn("new-test-type");
		return newToken;
	}
}
