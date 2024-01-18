package com.techfolks.service.impl;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.request.InitiateKycManual;
import com.techfolks.model.response.GetCaptchaResponse;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.techfolks.model.response.InitiateKycManualResponse;

@Service
public class KycServiceImpl implements KycService {
	
	private String clientID = "41487515";
	private String clientSecret = "YUoLRXhucHH6dKXCqi8Emhaqt6dgALvK";
	private String apiUrl = "https://svcdemo.digitap.work/ent/v3/kyc/";

	@Override
	public InitiateKycAutoResponse initiateAutoKycFunc(InitiateKycAuto initiateAutoKyc) throws JsonProcessingException, JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().writeValueAsString(initiateAutoKyc);
        ResponseEntity<String> result = restAPICall(apiUrl+"intiate-kyc-auto", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        InitiateKycAutoResponse jsonObject = new ObjectMapper().readValue(responseBody, InitiateKycAutoResponse.class);
        return jsonObject;
	}
	
	@Override
	public InitiateKycManualResponse initiateManualKycFunc(InitiateKycManual initiateManualKyc) throws JsonProcessingException, JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().writeValueAsString(initiateManualKyc);
        ResponseEntity<String> result = restAPICall(apiUrl+"intiate-kyc", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        InitiateKycManualResponse jsonObject = new ObjectMapper().readValue(responseBody, InitiateKycManualResponse.class);
        return jsonObject;
	}
	
	@Override
	public GetCaptchaResponse getCaptchaFunc() throws JsonProcessingException, JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> result = restAPICall(apiUrl+"get-captcha", null, HttpMethod.GET);
        String responseBody = result.getBody();
        GetCaptchaResponse jsonObject = new ObjectMapper().readValue(responseBody, GetCaptchaResponse.class);
        return jsonObject;
	}
	
	public ResponseEntity<String> restAPICall(String url, String data, HttpMethod type) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String originalString = clientID+":"+clientSecret;
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        headers.set(HttpHeaders.AUTHORIZATION, encodedString);
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, type, requestEntity, String.class);
        return responseEntity;
	}
}
