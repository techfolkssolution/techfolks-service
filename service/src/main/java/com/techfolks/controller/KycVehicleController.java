package com.techfolks.controller;

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
import com.techfolks.model.request.AssetVehicleRCValidation;
import com.techfolks.model.request.KycDrivingLicenseValidation;
import com.techfolks.model.response.ErrorResponse;
import com.techfolks.model.response.KycErrorResponse;
import com.techfolks.model.response.KycSuccessResponse;
import com.techfolks.service.impl.KycVehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/kyc/vehicle")
public class KycVehicleController {
	
	@Autowired
	private KycVehicleService kycVehicleService;
	
	@PostMapping("/rc")
	public ResponseEntity<?> assetVehicleRCValidation(@Valid @RequestBody AssetVehicleRCValidation assetVehicleRC) throws JsonMappingException, JsonProcessingException {
		try {
			KycSuccessResponse assetVehicleRCResponse = kycVehicleService.AssetVehicleRCValidationFunc(assetVehicleRC);
			return ResponseEntity.status(HttpStatus.OK).body(assetVehicleRCResponse);
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
	
	@PostMapping("/dl")
	public ResponseEntity<?> kycDrivingLicenseValidation(@Valid @RequestBody KycDrivingLicenseValidation kycDrivingLicense) throws JsonMappingException, JsonProcessingException {
		try {
			KycSuccessResponse kycDrivingLicenseResponse = kycVehicleService.KycDrivingLicenseValidationFunc(kycDrivingLicense);
			return ResponseEntity.status(HttpStatus.OK).body(kycDrivingLicenseResponse);
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
