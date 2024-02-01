package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techfolks.model.request.KycPassportValidation;
import com.techfolks.model.response.KycSuccessResponse;

public interface KycPassportService {

	KycSuccessResponse kycPassportValidationFunc(KycPassportValidation kycPassport) throws JsonProcessingException;

}
