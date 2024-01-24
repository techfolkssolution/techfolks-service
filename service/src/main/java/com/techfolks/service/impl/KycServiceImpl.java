package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.request.ReSendOtp;
import com.techfolks.model.request.SubmitOtp;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.techfolks.model.response.ReSendOtpResponse;
import com.techfolks.model.response.SubmitOtpResponse;
import com.techfolks.repository.ThirdPartyReqResRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Base64;

@Slf4j
@Service
public class KycServiceImpl implements KycService {

    @Autowired
    private ThirdPartyReqResRepository thirdPartyReqResRepository;

    @Autowired
    private RestTemplate restTemplate;


    private String clientID = "41487515";
    private String clientSecret = "YUoLRXhucHH6dKXCqi8Emhaqt6dgALvK";
    private String apiUrl = "https://svcdemo.digitap.work/ent/v3/kyc/";

    @Override
    public InitiateKycAutoResponse initiateAutoKycFunc(InitiateKycAuto initiateAutoKyc) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().writeValueAsString(initiateAutoKyc);
        ResponseEntity<String> result = restPostAPICall(apiUrl + "intiate-kyc-auto", jsonString);
        String responseBody = result.getBody();
        InitiateKycAutoResponse jsonObject = new ObjectMapper().readValue(responseBody, InitiateKycAutoResponse.class);
        return jsonObject;
    }

    public ResponseEntity<String> restPostAPICall(String url, String data) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String originalString = clientID + ":" + clientSecret;
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        headers.set(HttpHeaders.AUTHORIZATION, encodedString);
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return responseEntity;
    }

    @Override
    public SubmitOtpResponse submitOtp(SubmitOtp submitOtp) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().writeValueAsString(submitOtp);
        ResponseEntity<String> result = restPostAPICall(apiUrl + "submit-otp", jsonString);
        String responseBody = result.getBody();
        SubmitOtpResponse jsonObject = new ObjectMapper().readValue(responseBody, SubmitOtpResponse.class);
        return jsonObject;
    }

    @Override
    public ReSendOtpResponse resendOtp (ReSendOtp reSendOtp) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().writeValueAsString(reSendOtp);
        ResponseEntity<String> result = restPostAPICall(apiUrl + "resend-otp", jsonString);
        String responseBody = result.getBody();
        ReSendOtpResponse jsonObject = new ObjectMapper().readValue(responseBody, ReSendOtpResponse.class);
        return jsonObject;
    }
}
