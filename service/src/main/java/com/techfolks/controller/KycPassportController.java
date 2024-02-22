package com.techfolks.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.techfolks.model.request.KycPassportValidation;
import com.techfolks.model.response.ErrorResponse;
import com.techfolks.model.response.KycErrorResponse;
import com.techfolks.model.response.KycSuccessResponse;
import com.techfolks.service.impl.KycPassportService;

@RestController
@RequestMapping("/rest/kyc")
public class KycPassportController {
	
	@Autowired
	private KycPassportService kycPassportService;
	
	@PostMapping("/passport")
	public ResponseEntity<?> kycPassportValidation(@Valid @RequestBody KycPassportValidation kycPassport) throws JsonMappingException, JsonProcessingException {
		try {
			KycSuccessResponse initiateKycAutoResponse = kycPassportService.kycPassportValidationFunc(kycPassport);
			return ResponseEntity.status(HttpStatus.OK).body(initiateKycAutoResponse);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			try {
		        KycErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), KycErrorResponse.class);
		        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
		    } catch (MismatchedInputException ex) {
		        ErrorResponse mismatchedInputErrorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mismatchedInputErrorResponse);
		    }
        } catch (MismatchedInputException ex) {
	        ErrorResponse mismatchedInputErrorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mismatchedInputErrorResponse);
	    } catch (Exception e) {
			ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		} 
	}

}
