package com.revature.interfaces;

import java.io.Serializable;

// interfaces extend one another
public interface Flyable extends Cloneable, Serializable {

	public static final int SPEED = 100;
	
	// implicitely abstract
	public String fly();
	public default String flyFaster() {
		return "I'm flying at " + SPEED;
	}
	
}
