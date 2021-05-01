package com.revature.models;

public final class Dog extends Animal {
	
	String breed;

	// private final Person owner = new Person();
	
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	// static block runs when the class is loaded (before the main methods)
	static {
		
	}
	
	// instance block that runs when an object is instantiated/ before the constructor
	{
		
	}
	
	public Dog() {
	}

	public Dog(int age) {
		super(age);
	}
	
	public void fetch() {
		System.out.println("I'm fetching");
	}
	
	public void fetch(int times) {
		for(int i = 0; i < times; i++) {
			System.out.println("I'm fetching!");
		}
	}
	
	@Override
	public String moo() {
		return "Dog moo!";
	}

	@Override
	public String fly() {
		return "I'm flying";
	}
}
