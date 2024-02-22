package com.techfolks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.KycVoterValidation;
import com.techfolks.model.response.KycSuccessResponse;

@Service
public class KycVoterServiceImpl implements KycVoterService {
	
	@Autowired
	CommonService commonService;
	
	@Override
    public KycSuccessResponse kycVoterValidationFunc(KycVoterValidation kycVoter) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycVoter);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("voter", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }

}
