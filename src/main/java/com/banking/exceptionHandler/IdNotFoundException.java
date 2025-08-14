package com.banking.exceptionHandler;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException{
	
	public IdNotFoundException() {
		super("Account id not found");
	}

}
