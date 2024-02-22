package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techfolks.model.request.KycPanAadharLinkValidation;
import com.techfolks.model.request.KycPanAdvanceValidation;
import com.techfolks.model.request.KycPanBasicValidation;
import com.techfolks.model.request.KycPanDetailsValidation;
import com.techfolks.model.response.KycSuccessResponse;

public interface KycPanService {

	KycSuccessResponse KycPanBasicValidationFunc(KycPanBasicValidation kycPanBasicValidation)
			throws JsonProcessingException;

	KycSuccessResponse KycPanAdvanceValidationFunc(KycPanAdvanceValidation kycPanAdvanceValidation)
			throws JsonProcessingException;

	KycSuccessResponse KycPanDetailsValidationFunc(KycPanDetailsValidation kycPanDetailsValidation)
			throws JsonProcessingException;

	KycSuccessResponse KycFormValidationFunc(KycPanDetailsValidation kycFormValidation) throws JsonProcessingException;

	KycSuccessResponse KycPanAadharLinkValidationFunc(KycPanAadharLinkValidation kycPanAadharLinkValidation)
			throws JsonProcessingException;

	KycSuccessResponse KycPanMaskedAadharLinkValidationFunc(KycPanAadharLinkValidation kycPanMaskedAadharLinkValidation)
			throws JsonProcessingException;

}
