package com.digitapokyc.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InitiateKycManual {
	public String uniqueId;
	public String uid;
	public String captcha;
	public String captchaTxnId;
	public String cookieValue;
}
