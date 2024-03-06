package com.techfolks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.KycPassportValidation;
import com.techfolks.model.response.KycSuccessResponse;

@Service
public class KycPassportServiceImpl implements KycPassportService {
	
	@Autowired
	CommonService commonService;
	
	@Override
	@Cacheable(value = "kycPassportLinkValidation")
    public KycSuccessResponse kycPassportValidationFunc(KycPassportValidation kycPassport) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycPassport);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("passport", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }

}
