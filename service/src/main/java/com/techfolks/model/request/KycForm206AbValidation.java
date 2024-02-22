package com.techfolks.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycForm206AbValidation {
    @NotNull
    @Size(max = 45)
    private String client_ref_num;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^[A-Za-z]{4}[A-Za-z]{1}\\d{4}[A-Za-z]{1}$", message = "Pan number is not valid")
    private String pan;
}
