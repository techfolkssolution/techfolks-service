package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.techfolks.model.request.KycPanAdvanceValidation;
import com.techfolks.model.request.KycPanBasicValidation;
import com.techfolks.model.request.KycPanDetailsValidation;
import com.techfolks.model.response.KycSuccessResponse;

public interface KycPanService {

    KycSuccessResponse basicPanValidation(KycPanBasicValidation panBasicValidationRequest)
            throws JsonMappingException, JsonProcessingException;

    KycSuccessResponse advancePanValidation(KycPanAdvanceValidation panAdvanceValidationRequest)
            throws JsonMappingException, JsonProcessingException;

    public KycSuccessResponse panDetailsValidation(KycPanDetailsValidation kycPanDetailsValidation)
            throws JsonMappingException, JsonProcessingException;
}
