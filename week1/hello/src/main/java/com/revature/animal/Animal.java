package com.revature.animal;

public class Animal {

	// Fields: [access modifier] [non-access modifiers] [datatype] [variable name]
	public int age;
	
	// noargs constructor
	Animal() {

	}
	// parameterized constructor
	Animal(int age) {
		this.age = age;
	}
	
	// Methods: [access modifier] [non-access modifiers] [return type] [method name]([parameter list (if any)])
	public void makeNoise() {
		System.out.println("General animal noise");
	}
	
	public String cry() {
		return "crying";
	}
}
