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
import com.techfolks.model.request.KycForm206AbValidation;
import com.techfolks.model.response.ErrorResponse;
import com.techfolks.model.response.KycSuccessResponse;
import com.techfolks.service.impl.KycFormService;

@RestController
@RequestMapping("/kyc")
public class KycFormController {

    @Autowired
    private KycFormService kycFormService;


    @PostMapping("/form206ab_validation")
    public ResponseEntity<?> form206AbValidation(@RequestBody KycForm206AbValidation kycForm206AValidationRequest) throws JsonMappingException, JsonProcessingException {
        try {
            KycSuccessResponse form206Validation = kycFormService.form206Validation(kycForm206AValidationRequest);
            return ResponseEntity.status(HttpStatus.OK).body(form206Validation);
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
