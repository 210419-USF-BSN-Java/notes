package com.revature.models;

import com.revature.interfaces.Flyable;

public class Animal implements Flyable{

	private int age;
	private int numberOfFeet;
	private boolean canFly;
	private String name;

	// When no constructors have been defined, a default no args constructor is
	// provided
	// no args
	  public Animal() { 
		  // if no parameters are provided default values will be used 
		  }


	public Animal(int age) {
		// "this" refers to the instance to avoid variable shadowing
		this.age = age;
	}

	public Animal(int age, int numberOfFeet, boolean canFly, String name) {
		super();
		this.age = age;
		this.numberOfFeet = numberOfFeet;
		this.canFly = canFly;
		this.name = name;
	}


	public String moo() {
		return "Generic animal moo!!";
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) {
			this.age = 0;
		} else {
			this.age = age;
		}
	}

	public int getNumberOfFeet() {
		return numberOfFeet;
	}

	public void setNumberOfFeet(int numberOfFeet) {
		this.numberOfFeet = numberOfFeet;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// When a SYSO is called on an object, the toString() method is called, therefore override in order to provide message wanted
	@Override
	public String toString() {
		return "Animal [age=" + age + ", numberOfFeet=" + numberOfFeet + ", canFly=" + canFly + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (canFly ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfFeet;
		return result;
	}

	// Override equals to compare objects based on the classes' fields
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (canFly != other.canFly)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfFeet != other.numberOfFeet)
			return false;
		return true;
	}


	@Override
	public String fly() {
		// TODO Auto-generated method stub
		return "Animals flyin'";
	}
	
}
