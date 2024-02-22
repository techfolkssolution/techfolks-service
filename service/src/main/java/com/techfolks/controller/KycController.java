package com.techfolks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.request.InitiateKycManual;
import com.techfolks.model.request.ReSendOtp;
import com.techfolks.model.request.SubmitOtp;
import com.techfolks.model.response.ErrorResponse;
import com.techfolks.model.response.GetCaptchaResponse;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.techfolks.model.response.InitiateKycManualResponse;
import com.techfolks.model.response.ReSendOtpResponse;
import com.techfolks.model.response.SubmitOtpResponse;
import com.techfolks.service.impl.KycService;

@RestController
@RequestMapping("/rest/okyc")
public class KycController {
	
    @Autowired
    private KycService kycService;

    @PostMapping("/initiate-kyc-auto")
    public ResponseEntity<?> initiateKycAuto(@RequestBody InitiateKycAuto initiateAutoKyc) throws JsonMappingException, JsonProcessingException {
        try {
            InitiateKycAutoResponse initiateKycAutoResponse = kycService.initiateAutoKycFunc(initiateAutoKyc);
            return ResponseEntity.status(HttpStatus.OK).body(initiateKycAutoResponse);
        } catch (HttpClientErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (HttpServerErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/initiate-kyc-manual")
    public ResponseEntity<?> initiateKycManual(@RequestBody InitiateKycManual initiateManualKyc) throws JsonMappingException, JsonProcessingException {
        try {
            InitiateKycManualResponse initiateKycManualResponse = kycService.initiateManualKycFunc(initiateManualKyc);
            return ResponseEntity.status(HttpStatus.OK).body(initiateKycManualResponse);
        } catch (HttpClientErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (HttpServerErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/get-captcha")
    public ResponseEntity<?> getCaptcha() throws JsonMappingException, JsonProcessingException {
        try {
            GetCaptchaResponse getCaptchaResponse = kycService.getCaptchaFunc();
            return ResponseEntity.status(HttpStatus.OK).body(getCaptchaResponse);
        } catch (HttpClientErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (HttpServerErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/submitOtp")
    public ResponseEntity<?> submitOtpRequest(@RequestBody SubmitOtp submitOtp) throws JsonMappingException, JsonProcessingException {
        try {
            SubmitOtpResponse submitOtpResponse = kycService.submitOtp(submitOtp);
            return ResponseEntity.status(HttpStatus.OK).body(submitOtpResponse);
        } catch (HttpClientErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (HttpServerErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/resendOtp")
    public ResponseEntity<?> resendOtp(@RequestBody ReSendOtp reSendOtp) throws JsonMappingException, JsonProcessingException {
        try {
            ReSendOtpResponse reSendOtpResponse = kycService.resendOtp(reSendOtp);
            return ResponseEntity.status(HttpStatus.OK).body(reSendOtpResponse);
        } catch (HttpClientErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (HttpServerErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}

}
