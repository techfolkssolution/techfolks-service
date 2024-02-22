package com.techfolks.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycPassportValidation {
	@NotNull
	@NotBlank
	@Size(max = 45)
	public String client_ref_num;
	@NotNull
	@NotBlank
	@Size(min = 10, max = 14)
	@Pattern(regexp = "^[a-zA-Z]{2}\\d{2}[A-Z0-9]\\d{10}$|^[a-zA-Z]{4}\\d{8}$", message = "Passport is not valid")
	public String file_number;
	@NotNull
	@NotBlank
	public String dob;
}
