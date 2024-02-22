package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techfolks.model.request.AssetVehicleRCValidation;
import com.techfolks.model.request.KycDrivingLicenseValidation;
import com.techfolks.model.response.KycSuccessResponse;

public interface KycVehicleService {

	KycSuccessResponse AssetVehicleRCValidationFunc(AssetVehicleRCValidation assetVehicleRCValidation)
			throws JsonProcessingException;

	KycSuccessResponse KycDrivingLicenseValidationFunc(KycDrivingLicenseValidation kycDrivingLicenseValidation)
			throws JsonProcessingException;

}
