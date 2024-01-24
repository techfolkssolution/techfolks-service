package com.techfolks.service.impl;

import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.request.ReSendOtp;
import com.techfolks.model.request.SubmitOtp;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.techfolks.model.response.ReSendOtpResponse;
import com.techfolks.model.response.SubmitOtpResponse;

public interface KycService {
	InitiateKycAutoResponse initiateAutoKycFunc(InitiateKycAuto initiateAutoKyc) throws JsonProcessingException;

	SubmitOtpResponse submitOtp(SubmitOtp submitOtp) throws JsonProcessingException ;

	ReSendOtpResponse resendOtp(ReSendOtp reSendOtp) throws JsonProcessingException;
}
