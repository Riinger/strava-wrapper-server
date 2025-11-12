package com.gade.gps.strava.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.gade.gps.strava.client.ApiClient;
import com.gade.gps.strava.client.auth.OAuth;
import com.gade.gps.strava.config.StravaProperties;
import com.gade.gps.strava.oauth.OAuthHelper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RepositoryHelper {
	
	final StravaProperties stravaProperties;
	final OAuthHelper oauthHelper;

	RepositoryHelper(StravaProperties stravaProperties, OAuthHelper oauthHelper) {
        this.stravaProperties = stravaProperties;
        this.oauthHelper = oauthHelper;
    }
	
	public ApiClient getApiClient() throws IOException {
		var apiClient = new ApiClient(buildRestTemplate());
		// Configure OAuth2 access token for authorization: strava_oauth
		var stravaOauth = (OAuth) apiClient.getAuthentication("strava_oauth");
		stravaOauth.setAccessToken(oauthHelper.getAccessToken());
		return apiClient;
	}

    private RestTemplate buildRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));

        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory();
        uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        restTemplate.setUriTemplateHandler(uriBuilderFactory);
        
        restTemplate.setInterceptors(List.of(new ApiClientHttpRequestInterceptor()));
        return restTemplate;
    }
    protected class ApiClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            logRequest(request, body);
            ClientHttpResponse response = execution.execute(request, body);
            logResponse(response);
            return response;
        }

        protected void logRequest(HttpRequest request, byte[] body) {
    		log.info("===> Invoking downstream API : URI = '{}', Method = '{}', Headers = '{}'", 
    				request.getURI(), 
    				request.getMethod(), headersToString(request.getHeaders()));

        }

        protected void logResponse(ClientHttpResponse response) throws IOException {
//            log.info("HTTP Status Code: " + response.getStatusCode().value());
//            log.info("Status Text: " + response.getStatusText());
//            log.info("HTTP Headers: " + headersToString(response.getHeaders()));
//            log.info("Response Body: " + bodyToString(response.getBody()));
    		log.info("<== Downstream API returned : HTTP Status Code = '{}', Status Text = '{}', Headers = '{}'", 
    				response.getStatusCode().value(),
    				response.getStatusText(),
    				headersToString(response.getHeaders()));
        }

        protected String headersToString(HttpHeaders headers) {
            if(headers == null || headers.isEmpty()) return "";
    		return headers
    				.keySet()
    				.stream()
    				.filter(k -> !k.equalsIgnoreCase("Authorization"))
    				.map(k -> k + "=" + headers.get(k))
    				  .collect(Collectors.joining(",", "{", "}"));
        }

        protected String bodyToString(InputStream body) throws IOException {
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
    }

}
