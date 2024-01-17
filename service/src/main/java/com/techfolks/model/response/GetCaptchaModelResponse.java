package com.techfolks.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCaptchaModelResponse {
	public String captchaTxnId;
	public String imageBase64;
	public String codeVerifier;
	public String cookieValue;
}
