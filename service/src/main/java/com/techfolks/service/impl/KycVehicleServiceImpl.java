package com.techfolks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.AssetVehicleRCValidation;
import com.techfolks.model.request.KycDrivingLicenseValidation;
import com.techfolks.model.response.KycSuccessResponse;

@Service
public class KycVehicleServiceImpl implements KycVehicleService {
	
	@Autowired
	CommonService commonService;

    @Autowired
    ThirdPartyReqRes thirdPartyReqRes;
	
	@Override
    public KycSuccessResponse AssetVehicleRCValidationFunc(AssetVehicleRCValidation assetVehicleRCValidation) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(assetVehicleRCValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("rc", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        thirdPartyReqRes.saveThirdPartyReqRes("rc",jsonString,responseBody);
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }
	
	@Override
    public KycSuccessResponse KycDrivingLicenseValidationFunc(KycDrivingLicenseValidation kycDrivingLicenseValidation) throws JsonProcessingException {
        String jsonString = new ObjectMapper().writeValueAsString(kycDrivingLicenseValidation);
        ResponseEntity<String> result = commonService.kycNewRestAPICall("dl", jsonString, HttpMethod.POST);
        String responseBody = result.getBody();
        thirdPartyReqRes.saveThirdPartyReqRes("dl",jsonString,responseBody);
        KycSuccessResponse jsonObject = new ObjectMapper().readValue(responseBody, KycSuccessResponse.class);
        return jsonObject;
    }

}
