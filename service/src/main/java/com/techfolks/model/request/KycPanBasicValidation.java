package com.techfolks.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techfolks.enums.NameMatchMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycPanBasicValidation {
	@NotNull
	@NotBlank
	@Size(max = 45)
	public String client_ref_num;
	@NotNull
	@NotBlank
	@Size(min = 10, max = 10)
	@Pattern(regexp = "^[A-Za-z]{4}[A-Za-z]{1}\\d{4}[A-Za-z]{1}$", message = "Pan number is not valid")
	public String pan;
	@Size(min = 1, max = 150)
	public String name;
	public NameMatchMethod name_match_method;
}
