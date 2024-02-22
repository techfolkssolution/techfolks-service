package com.techfolks.model.response;

import java.util.ArrayList;

import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationFailedResponse {
	
	public HttpStatusCode code;
	public ArrayList<ValidationError> data;

}
