package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.request.InitiateKycManual;
import com.techfolks.model.response.GetCaptchaResponse;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.techfolks.model.response.InitiateKycManualResponse;

public interface KycService {
	InitiateKycAutoResponse initiateAutoKycFunc(InitiateKycAuto initiateAutoKyc) throws JsonProcessingException;

	InitiateKycManualResponse initiateManualKycFunc(InitiateKycManual initiateManualKyc)
			throws JsonProcessingException, JsonProcessingException;

	GetCaptchaResponse getCaptchaFunc() throws JsonProcessingException, JsonProcessingException;
}
