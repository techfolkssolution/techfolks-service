package com.techfolks.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.dto.Api;
import com.techfolks.model.dto.ThirdPartyReqRes;
import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.request.InitiateKycManual;
import com.techfolks.model.request.ReSendOtp;
import com.techfolks.model.request.SubmitOtp;
import com.techfolks.model.response.GetCaptchaResponse;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.techfolks.model.response.InitiateKycManualResponse;
import com.techfolks.model.response.ReSendOtpResponse;
import com.techfolks.model.response.SubmitOtpResponse;
import com.techfolks.repository.ApiRepository;
import com.techfolks.repository.ThirdPartyReqResRepository;

@Service
public class KycServiceImpl implements KycService {

    @Autowired
    private ThirdPartyReqResRepository thirdPartyReqResRepository;
    
	@Autowired
	CommonService commonService;

    @Autowired
    private ApiRepository apiRepository;

    @Override
	@Cacheable(value = "initiateManualKyc")
    public InitiateKycManualResponse initiateManualKycFunc(InitiateKycManual initiateManualKyc) throws JsonProcessingException, JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().writeValueAsString(initiateManualKyc);
        ResponseEntity<String> result = commonService.kycRestAPICall("intiate-kyc", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();

        saveThirdPartyReqRes("intiate-kyc", jsonString, responseBody);

        InitiateKycManualResponse jsonObject = new ObjectMapper().readValue(responseBody, InitiateKycManualResponse.class);
        return jsonObject;
    }

    @Override
	@CachePut(value = "getCaptcha")
    public GetCaptchaResponse getCaptchaFunc() throws JsonProcessingException, JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> result = commonService.kycRestAPICall("get-captcha", null, HttpMethod.GET);
        String responseBody = result.getBody();

        saveThirdPartyReqRes("get-captcha", null, responseBody);

        GetCaptchaResponse jsonObject = new ObjectMapper().readValue(responseBody, GetCaptchaResponse.class);
        return jsonObject;
    }
    @Override
    @Cacheable(value = "initiateAutoKyc", key="#initiateAutoKyc.uid")
    public InitiateKycAutoResponse initiateAutoKycFunc(InitiateKycAuto initiateAutoKyc) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(initiateAutoKyc);
        ResponseEntity<String> result = commonService.kycRestAPICall("intiate-kyc-auto", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();

        saveThirdPartyReqRes("intiate-kyc-auto", jsonString, responseBody);

        InitiateKycAutoResponse jsonObject = new ObjectMapper().readValue(responseBody, InitiateKycAutoResponse.class);
        return jsonObject;
    }
    	

    @Override
	@Cacheable(value = "submitOtp")
    public SubmitOtpResponse submitOtp(SubmitOtp submitOtp) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(submitOtp);
        ResponseEntity<String> result = commonService.kycRestAPICall("submit-otp", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();

        saveThirdPartyReqRes("submit-otp", jsonString, responseBody);

        SubmitOtpResponse jsonObject = new ObjectMapper().readValue(responseBody, SubmitOtpResponse.class);
        return jsonObject;
    }

    @Override
	@Cacheable(value = "resendOtp")
    public ReSendOtpResponse resendOtp (ReSendOtp reSendOtp) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().writeValueAsString(reSendOtp);
        ResponseEntity<String> result = commonService.kycRestAPICall("resend-otp", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();

        saveThirdPartyReqRes("resend-otp", jsonString, responseBody);

        ReSendOtpResponse jsonObject = new ObjectMapper().readValue(responseBody, ReSendOtpResponse.class);
        return jsonObject;
    }

    private void saveThirdPartyReqRes(String apiName, String request, String response) {
        Api existingApi = apiRepository.findByApi(apiName);

        if (existingApi == null) {
            existingApi = new Api();
            existingApi.setApi(apiName);
            apiRepository.save(existingApi);
        }
        ThirdPartyReqRes thirdPartyReqRes = new ThirdPartyReqRes();
        thirdPartyReqRes.setRequest(request);
        thirdPartyReqRes.setResponse(response);
        thirdPartyReqRes.setApi(existingApi);
        thirdPartyReqResRepository.save(thirdPartyReqRes);
    }
}
