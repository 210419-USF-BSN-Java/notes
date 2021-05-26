package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="A random popped up exception")
	@ExceptionHandler(Exception.class)
	public void handleException() {
		System.out.println("random Exception thrown");
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="No employee with given ID")
	@ExceptionHandler(EmployeeNotFoundException.class)
	public void handleEmployeeNotFoundException() {
		System.out.println("EmployeeNotFoundException thrown");
	}
	


}