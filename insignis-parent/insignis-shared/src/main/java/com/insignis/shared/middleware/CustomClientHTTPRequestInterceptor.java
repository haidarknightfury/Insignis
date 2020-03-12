package com.insignis.shared.middleware;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class CustomClientHTTPRequestInterceptor implements ClientHttpRequestInterceptor {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomClientHTTPRequestInterceptor.class);

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		logRequestDetails(request);
		return execution.execute(request, body);
	}

	private void logRequestDetails(HttpRequest request) {
		LOGGER.info("Headers : {}", request.getHeaders());
		LOGGER.info("Request method : {}", request.getMethod());
		LOGGER.info("Request URI : {}", request.getURI());
	}

}
