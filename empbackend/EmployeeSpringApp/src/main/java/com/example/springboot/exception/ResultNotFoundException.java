package com.example.springboot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResultNotFoundException extends RuntimeException {
	public  ResultNotFoundException(String message) {
		super(message);
	
	}
	
	
}
