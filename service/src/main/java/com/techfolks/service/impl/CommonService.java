package com.techfolks.service.impl;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface CommonService {

	ResponseEntity<String> kycRestAPICall(String url, String data, HttpMethod type);

	ResponseEntity<String> kycNewRestAPICall(String url, String data, HttpMethod type);


}
