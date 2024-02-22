package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.KycForm206AbValidation;
import com.techfolks.model.response.KycSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KycFormServiceImpl implements KycFormService {

    @Autowired
    private CommonService commonService;

    @Override
    public KycSuccessResponse form206Validation(KycForm206AbValidation kycForm206AValidation)
            throws JsonMappingException, JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().writeValueAsString(kycForm206AValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("form206ab_compliance_status", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }
}
