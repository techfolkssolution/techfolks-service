package com.techfolks.service.impl;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommonServiceImpl implements CommonService {
	
	private String clientID = "41487515";
    private String clientSecret = "YUoLRXhucHH6dKXCqi8Emhaqt6dgALvK";
    private String kycApiUrl = "https://svcdemo.digitap.work/ent/v3/kyc/";
    private String kycNewApiUrl = "https://svcdemo.digitap.work/validation/kyc/v1/";
	
	@Override
	public ResponseEntity<String> kycRestAPICall(String url, String data, HttpMethod type) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String originalString = clientID + ":" + clientSecret;
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        headers.set(HttpHeaders.AUTHORIZATION, encodedString);
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(kycApiUrl+url, type, requestEntity, String.class);
        return responseEntity;
    }
	
	@Override
	public ResponseEntity<String> kycNewRestAPICall(String url, String data, HttpMethod type) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String originalString = clientID + ":" + clientSecret;
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        headers.set(HttpHeaders.AUTHORIZATION, encodedString);
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(kycNewApiUrl+url, type, requestEntity, String.class);
        return responseEntity;
    }

}
