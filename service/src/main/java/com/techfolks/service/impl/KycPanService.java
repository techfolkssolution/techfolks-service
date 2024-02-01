package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techfolks.model.request.KycPanBasicValidation;
import com.techfolks.model.response.KycSuccessResponse;

public interface KycPanService {

	KycSuccessResponse KycPanBasicValidationFunc(KycPanBasicValidation kycPanBasicValidation)
			throws JsonProcessingException;

}
