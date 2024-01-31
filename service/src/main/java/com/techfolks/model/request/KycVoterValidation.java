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
public class KycVoterValidation {
	@NotNull
	@Size(max = 45)
	public String client_ref_num;
	@NotNull
	@Size(min = 10, max = 23)
	@Pattern(regexp = "^(([a-zA-Z]{3}\\/?\\d{6,7})|([a-zA-Z]{2}\\/\\d{1,3}\\/\\d{2,3}\\/\\d{6,7})|([a-zA-Z]{2}\\d{10,12}))$", message = "Voter ID is not valid")
	public String epic_number;
	@NotNull
	public String dob;
}
