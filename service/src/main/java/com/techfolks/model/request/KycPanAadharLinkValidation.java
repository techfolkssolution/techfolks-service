package com.techfolks.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycPanAadharLinkValidation {
	@NotNull
	@Size(max = 45)
	public String client_ref_num;
	@NotNull
	@Size(min = 10, max = 10)
	@Pattern(regexp = "^[A-Za-z]{4}[A-Za-z]{1}\\d{4}[A-Za-z]{1}$", message = "Pan number is not valid")
	public String pan;
	@NotNull
	@Size(min = 12, max = 12)
	public String aadhaar;
}
