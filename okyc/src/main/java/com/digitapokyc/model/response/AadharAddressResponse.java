package com.digitapokyc.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AadharAddressResponse {
	public String street;
	public String Landmark;
	public String loc;
	public String po;
	public String dist;
	public String subdist;
	public String vtc;
	public String pc;
	public String state;
	public String country;
}
