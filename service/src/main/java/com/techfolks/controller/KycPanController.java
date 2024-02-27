package com.techfolks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.techfolks.model.request.KycPanAadharLinkValidation;
import com.techfolks.model.request.KycPanAdvanceValidation;
import com.techfolks.model.request.KycPanBasicValidation;
import com.techfolks.model.request.KycPanDetailsValidation;
import com.techfolks.model.response.ErrorResponse;
import com.techfolks.model.response.KycErrorResponse;
import com.techfolks.model.response.KycSuccessResponse;
import com.techfolks.service.impl.KycPanService;
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

@RestController
@RequestMapping("/rest/kyc")
public class KycPanController {

    @Autowired
    private KycPanService kycPanService;

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

    @PostMapping("/pan/details")
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
	
	@PostMapping("/pan/basic-validation")
	public ResponseEntity<?> kycPanBasicValidation(@Valid @RequestBody KycPanBasicValidation kycPanBasic) throws JsonMappingException, JsonProcessingException {
		try {
			KycSuccessResponse kycPanBasicResponse = kycPanService.KycPanBasicValidationFunc(kycPanBasic);
			return ResponseEntity.status(HttpStatus.OK).body(kycPanBasicResponse);
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
	
//	@PostMapping("/pan")
//	public ResponseEntity<?> kycPanValidation(@Valid @RequestBody KycPanAdvanceValidation kycPanAdvance) throws JsonMappingException, JsonProcessingException {
//		try {
//			KycSuccessResponse kycPanResponse = kycPanService.KycPanAdvanceValidationFunc(kycPanAdvance);
//			return ResponseEntity.status(HttpStatus.OK).body(kycPanResponse);
//		} catch (HttpClientErrorException | HttpServerErrorException e) {
//			try {
//		        KycErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), KycErrorResponse.class);
//		        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
//		    } catch (MismatchedInputException ex) {
//		        ErrorResponse mismatchedInputErrorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
//		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mismatchedInputErrorResponse);
//		    }
//        } catch (MismatchedInputException ex) {
//	        ErrorResponse mismatchedInputErrorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mismatchedInputErrorResponse);
//	    } catch (Exception e) {
//			ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//		}
//	}

	
	@PostMapping("/pan/aadhaar-link")
	public ResponseEntity<?> kycPanAadharLinkValidation(@Valid @RequestBody KycPanAadharLinkValidation kycPanAadharLink) throws JsonMappingException, JsonProcessingException {
		try {
			KycSuccessResponse kycPanAadharLinkResponse = kycPanService.KycPanAadharLinkValidationFunc(kycPanAadharLink);
			return ResponseEntity.status(HttpStatus.OK).body(kycPanAadharLinkResponse);
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
	
	@PostMapping("/pan/masked-aadhaar-link")
	public ResponseEntity<?> kycPanMaskedAadharLinkValidation(@Valid @RequestBody KycPanAadharLinkValidation kycPanMaskedAadharLink) throws JsonMappingException, JsonProcessingException {
		try {
			KycSuccessResponse kycPanMaskedAadharLinkResponse = kycPanService.KycPanAadharLinkValidationFunc(kycPanMaskedAadharLink);
			return ResponseEntity.status(HttpStatus.OK).body(kycPanMaskedAadharLinkResponse);
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
