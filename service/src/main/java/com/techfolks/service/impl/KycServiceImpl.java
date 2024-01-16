package com.techfolks.service.impl;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KycServiceImpl implements KycService {
	
	private String clientID = "41487515";
	private String clientSecret = "YUoLRXhucHH6dKXCqi8Emhaqt6dgALvK";
	private String apiUrl = "https://svcdemo.digitap.work/ent/v3/kyc/";

	@Override
	public InitiateKycAutoResponse initiateAutoKycFunc(InitiateKycAuto initiateAutoKyc) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().writeValueAsString(initiateAutoKyc);
        ResponseEntity<String> result = restPostAPICall(apiUrl+"intiate-kyc-auto", jsonString);
        String responseBody = result.getBody();
        InitiateKycAutoResponse jsonObject = new ObjectMapper().readValue(responseBody, InitiateKycAutoResponse.class);
        return jsonObject;
	}
	
	public ResponseEntity<String> restPostAPICall(String url, String data) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String originalString = clientID+":"+clientSecret;
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        headers.set(HttpHeaders.AUTHORIZATION, encodedString);
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return responseEntity;
	}
}
