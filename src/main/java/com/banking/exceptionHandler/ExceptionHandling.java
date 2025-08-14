package com.banking.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.banking.controller.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idnotfound(IdNotFoundException exp) {
		ResponseStructure<String> resp = new ResponseStructure<String>(HttpStatus.NOT_FOUND.value(), exp.getMessage(), null);
		return new ResponseEntity<ResponseStructure<String>>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InSufficientBalance.class)
	public ResponseEntity<ResponseStructure<String>> idnotfound(InSufficientBalance exp) {
		ResponseStructure<String> resp = new ResponseStructure<String>(HttpStatus.UNPROCESSABLE_ENTITY.value(), exp.getMessage(), null);
		return new ResponseEntity<ResponseStructure<String>>(resp, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
}
