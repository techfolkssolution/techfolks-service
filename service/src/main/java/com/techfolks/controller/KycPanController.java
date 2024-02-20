package com.techfolks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.KycPanAdvanceValidation;
import com.techfolks.model.request.KycPanBasicValidation;
import com.techfolks.model.request.KycPanDetailsValidation;
import com.techfolks.model.response.ErrorResponse;
import com.techfolks.model.response.KycSuccessResponse;
import com.techfolks.service.impl.KycPanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequestMapping("/pan_validation")
public class KycPanController {

    @Autowired
    private KycPanService kycPanService;

    @PostMapping("/pan_basic")
    public ResponseEntity<?> basicPanValidation(@RequestBody KycPanBasicValidation panBasicValidationRequest) throws JsonMappingException, JsonProcessingException {
        try {
            KycSuccessResponse panBasicValidationResponse = kycPanService.basicPanValidation(panBasicValidationRequest);
            return ResponseEntity.status(HttpStatus.OK).body(panBasicValidationResponse);
        } catch (HttpClientErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch(HttpServerErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/pan_advance")
    public ResponseEntity<?> advancePanValidation(@RequestBody KycPanAdvanceValidation panAdvanceValidationRequest) throws JsonMappingException, JsonProcessingException {
        try {
            KycSuccessResponse panAdvanceValidationResponse = kycPanService.advancePanValidation(panAdvanceValidationRequest);
            return ResponseEntity.status(HttpStatus.OK).body(panAdvanceValidationResponse);
        } catch (HttpClientErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch(HttpServerErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/pan_details")
    public ResponseEntity<?> panDetailsValidation(@RequestBody KycPanDetailsValidation kycPanDetailsValidation) throws JsonMappingException, JsonProcessingException {
        try {
            KycSuccessResponse panDetailsValidationResponse = kycPanService.panDetailsValidation(kycPanDetailsValidation);
            return ResponseEntity.status(HttpStatus.OK).body(panDetailsValidationResponse);
        } catch (HttpClientErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch(HttpServerErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
