package com.banking.exceptionHandler;

@SuppressWarnings("serial")
public class InSufficientBalance extends RuntimeException {
	
	public InSufficientBalance() {
		super("Insufficient Balance");
	}

}
