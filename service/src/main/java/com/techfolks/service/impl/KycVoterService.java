package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techfolks.model.request.KycVoterValidation;
import com.techfolks.model.response.KycSuccessResponse;

public interface KycVoterService {

	KycSuccessResponse kycVoterValidationFunc(KycVoterValidation kycVoter) throws JsonProcessingException;

}
