package com.techfolks.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitOtp {
	public String shareCode;
	public String otp;
	public String codeVerifier;
	public String transactionId;
	public String fwdp;
	public Boolean validateXml;

}
