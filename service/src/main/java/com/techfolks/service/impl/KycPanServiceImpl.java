package com.techfolks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.KycPanAadharLinkValidation;
import com.techfolks.model.request.KycPanAdvanceValidation;
import com.techfolks.model.request.KycPanBasicValidation;
import com.techfolks.model.request.KycPanDetailsValidation;
import com.techfolks.model.response.KycSuccessResponse;

@Service
public class KycPanServiceImpl implements KycPanService {
	
	@Autowired
	CommonService commonService;
	
	@Override
    public KycSuccessResponse KycPanBasicValidationFunc(KycPanBasicValidation kycPanBasicValidation) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycPanBasicValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("pan_basic", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }
	
	@Override
    public KycSuccessResponse KycPanAdvanceValidationFunc(KycPanAdvanceValidation kycPanAdvanceValidation) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycPanAdvanceValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("pan", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }
	
	@Override
    public KycSuccessResponse KycPanDetailsValidationFunc(KycPanDetailsValidation kycPanDetailsValidation) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycPanDetailsValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("pan_details", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }
	
	@Override
    public KycSuccessResponse KycFormValidationFunc(KycPanDetailsValidation kycFormValidation) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycFormValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("form206ab_compliance_status", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }
	
	@Override
    public KycSuccessResponse KycPanAadharLinkValidationFunc(KycPanAadharLinkValidation kycPanAadharLinkValidation) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycPanAadharLinkValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("pan_aadhaar_link", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }
	
	@Override
    public KycSuccessResponse KycPanMaskedAadharLinkValidationFunc(KycPanAadharLinkValidation kycPanMaskedAadharLinkValidation) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycPanMaskedAadharLinkValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("pan_to_masked_aadhaar", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }

}
