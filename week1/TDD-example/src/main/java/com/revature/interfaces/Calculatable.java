package com.revature.interfaces;

import com.revature.exceptions.BoringNumberException;

public interface Calculatable {

	// TODO: if the result is an even number, an EvenNumberException should be thrown and a silly message should be returned 
	public abstract double add(double x, double y);
	
	// TODO: if the result is 1 or zero an exception should occur and the method should return -1
	public abstract double subtract(double x, double y) throws BoringNumberException;
	public abstract double multiply(double x, double y);
	public abstract double divide(double x, double y);
}
