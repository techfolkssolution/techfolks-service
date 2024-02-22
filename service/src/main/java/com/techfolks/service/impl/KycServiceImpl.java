package com.techfolks.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.request.InitiateKycManual;
import com.techfolks.model.request.ReSendOtp;
import com.techfolks.model.request.SubmitOtp;
import com.techfolks.model.response.GetCaptchaResponse;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.techfolks.model.response.InitiateKycManualResponse;
import com.techfolks.model.response.ReSendOtpResponse;
import com.techfolks.model.response.SubmitOtpResponse;

@Service
public class KycServiceImpl implements KycService {

	@Autowired
	CommonService commonService;
		
	@Override
	public InitiateKycManualResponse initiateManualKycFunc(InitiateKycManual initiateManualKyc) throws JsonProcessingException, JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(initiateManualKyc);
        ResponseEntity<String> result = commonService.kycRestAPICall("intiate-kyc", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        InitiateKycManualResponse jsonObject = new ObjectMapper().readValue(responseBody, InitiateKycManualResponse.class);
        return jsonObject;
	}
	
	@Override
	public GetCaptchaResponse getCaptchaFunc() throws JsonProcessingException, JsonProcessingException {
        ResponseEntity<String> result = commonService.kycRestAPICall("get-captcha", null, HttpMethod.GET);
        String responseBody = result.getBody();
        GetCaptchaResponse jsonObject = new ObjectMapper().readValue(responseBody, GetCaptchaResponse.class);
        return jsonObject;
	}

    @Override
    public InitiateKycAutoResponse initiateAutoKycFunc(InitiateKycAuto initiateAutoKyc) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(initiateAutoKyc);
        ResponseEntity<String> result = commonService.kycRestAPICall("intiate-kyc-auto", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        InitiateKycAutoResponse jsonObject = new ObjectMapper().readValue(responseBody, InitiateKycAutoResponse.class);
        return jsonObject;
    }
    	

    @Override
    public SubmitOtpResponse submitOtp(SubmitOtp submitOtp) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(submitOtp);
        ResponseEntity<String> result = commonService.kycRestAPICall("submit-otp", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        SubmitOtpResponse jsonObject = new ObjectMapper().readValue(responseBody, SubmitOtpResponse.class);
        return jsonObject;
    }

    @Override
    public ReSendOtpResponse resendOtp (ReSendOtp reSendOtp) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(reSendOtp);
        ResponseEntity<String> result = commonService.kycRestAPICall("resend-otp", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        ReSendOtpResponse jsonObject = new ObjectMapper().readValue(responseBody, ReSendOtpResponse.class);
        return jsonObject;
    }
}
