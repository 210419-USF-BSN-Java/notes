package com.revature.models;

import java.io.Serializable;

import com.revature.exceptions.BrokenMotorException;

// ctrl+shift+o for automatic imports
// Java Bean
public class Car implements Serializable {

	private double maxSpeed;
	private Float price;
	private String make;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Car [maxSpeed=" + maxSpeed + ", price=" + price + ", make=" + make + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		long temp;
		temp = Double.doubleToLongBits(maxSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (Double.doubleToLongBits(maxSpeed) != Double.doubleToLongBits(other.maxSpeed))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void makeNoise(int x, int y, String... noises) throws BrokenMotorException {
		// when using & or |, both sides are evaluated
		/*
		 *  && and ||, have short circuiting behavior ie: 
		 *  	false && anything => false
		 *  	true || anything => true
		 */
		if (x > 0 && y > 0) {
			for (String noise : noises) {
				System.out.println(noise);
			}
		} else {
			throw new BrokenMotorException("Motor is dead.");
		}

	}

}
