package com.techfolks.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.techfolks.model.response.ValidationError;
import com.techfolks.model.response.ValidationFailedResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValid(MethodArgumentNotValidException ex) {
		ArrayList<ValidationError> arrayList = new ArrayList<ValidationError>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String field = ((FieldError) error).getField();
			String defaultMessage = error.getDefaultMessage();
			arrayList.add(new ValidationError(field, defaultMessage));
		});
		return new ResponseEntity<>(new ValidationFailedResponse(HttpStatus.BAD_REQUEST, arrayList), HttpStatus.BAD_REQUEST);
	}

}
