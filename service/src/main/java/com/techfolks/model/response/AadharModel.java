package com.techfolks.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AadharModel {
	public String adharNumber;
	public String uniqueId;
	public String referenceId;
	public String maskedAdharNumber;
	public String name;
	public String gender;
	public String dob;
	public String careOf;
	public String passCode;
	public String link;
	public AadharAddressResponse address;
	public String image;
	public String isXmlValid;

}
