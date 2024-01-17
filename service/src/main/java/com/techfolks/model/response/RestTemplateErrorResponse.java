package com.techfolks.model.response;

import java.io.IOException;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateErrorResponse implements ResponseErrorHandler {
	
	private final ResponseErrorHandler defaultHandler = new DefaultResponseErrorHandler();
	
	@Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return defaultHandler.hasError(response);
    }
	
	@Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatusCode statusCode = response.getStatusCode();
        String statusText = response.getStatusText();
        System.out.println("Error response: " + statusCode + " " + statusText);
    }

}
