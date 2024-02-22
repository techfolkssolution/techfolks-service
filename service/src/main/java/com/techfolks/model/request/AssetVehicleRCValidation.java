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
public class AssetVehicleRCValidation {
	@NotNull
	@NotBlank
	@Size(max = 45)
	public String client_ref_num;
	@NotNull
	@NotBlank
	@Size(min = 6, max = 20)
	@Pattern(regexp = "^[A-Z]{2}\\d[A-Z]{2}\\d{4}$|^[A-Z]{2}\\d{2}[A-Z0-9]{2}\\d{3,4}$|^[A-Z]{2}\\d{2}[A-Z]\\d{4}$|^[A-Z]{2}\\d{6}$|^[A-Z]{3}\\d{4}|^[A-Z]{2}\\d{1}[A-Z]{3}\\d{3,4}$|^[A-Z]{2}\\d{1}[A-Z]{1}\\d{4}|^[A-Z]{2}\\d{2}[A-Z]{1}\\d{3}$|^[A-Z]{2}\\d[A-Z]{3}\\d{4}$|^[A-Z]{2}\\d{2}[A-Z]{1,2}\\d{2}$|^[0-9]{2}[B,H]{2}[0-9]{4}[A-Z]{1,2}", message = "RC is not valid")
	public String reg_no;
}
