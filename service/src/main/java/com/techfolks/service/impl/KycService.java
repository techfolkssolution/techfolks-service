package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.request.InitiateKycManual;
import com.techfolks.model.response.GetCaptchaResponse;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.techfolks.model.response.InitiateKycManualResponse;
import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.request.ReSendOtp;
import com.techfolks.model.request.SubmitOtp;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.techfolks.model.response.ReSendOtpResponse;
import com.techfolks.model.response.SubmitOtpResponse;

public interface KycService {
	InitiateKycAutoResponse initiateAutoKycFunc(InitiateKycAuto initiateAutoKyc) throws JsonProcessingException;

	InitiateKycManualResponse initiateManualKycFunc(InitiateKycManual initiateManualKyc)
			throws JsonProcessingException, JsonProcessingException;

	GetCaptchaResponse getCaptchaFunc() throws JsonProcessingException, JsonProcessingException;

	SubmitOtpResponse submitOtp(SubmitOtp submitOtp) throws JsonProcessingException ;

	ReSendOtpResponse resendOtp(ReSendOtp reSendOtp) throws JsonProcessingException;
}
