package com.techfolks.service.impl;

import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface KycService {
	InitiateKycAutoResponse initiateAutoKycFunc(InitiateKycAuto initiateAutoKyc) throws JsonProcessingException;
}
