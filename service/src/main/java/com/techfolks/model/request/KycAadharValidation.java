package com.techfolks.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycAadharValidation {
	@NotNull
	@Size(max = 45)
	public String client_ref_num;
	@NotNull
	@Size(min = 12, max = 12)
	public String aadhaar;
}
