package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.techfolks.model.request.KycForm206AbValidation;
import com.techfolks.model.response.KycSuccessResponse;

public interface KycFormService {
    KycSuccessResponse form206Validation(KycForm206AbValidation kycForm206AValidation)
            throws JsonMappingException, JsonProcessingException;
}
