package com.digitapokyc.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycManualModelResponse {
	
	public String transactionId;
	public String fwdp;
	public UidaiResponse uidaiResponse;

}
