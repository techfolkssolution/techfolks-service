package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techfolks.model.request.KycAadharValidation;
import com.techfolks.model.response.KycSuccessResponse;

public interface KycAadharService {

	KycSuccessResponse KycAadharValidationFunc(KycAadharValidation kycAadharValidation) throws JsonProcessingException;

	KycSuccessResponse KycBasicAadharValidationFunc(KycAadharValidation kycAadharValidation)
			throws JsonProcessingException;

}
