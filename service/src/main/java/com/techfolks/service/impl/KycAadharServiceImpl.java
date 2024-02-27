package com.techfolks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.KycAadharValidation;
import com.techfolks.model.response.KycSuccessResponse;

@Service
public class KycAadharServiceImpl implements KycAadharService {
	
	@Autowired
	CommonService commonService;

    @Autowired
    ThirdPartyReqRes thirdPartyReqRes;
	
	@Override
    public KycSuccessResponse KycAadharValidationFunc(KycAadharValidation kycAadharValidation) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycAadharValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("aadhaar", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        thirdPartyReqRes.saveThirdPartyReqRes("aadhaar",jsonString,responseBody);
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }
	
	@Override
    public KycSuccessResponse KycBasicAadharValidationFunc(KycAadharValidation kycAadharValidation) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycAadharValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("basic_aadhaar", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        thirdPartyReqRes.saveThirdPartyReqRes("basic_aadhaar",jsonString,responseBody);
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }

}
