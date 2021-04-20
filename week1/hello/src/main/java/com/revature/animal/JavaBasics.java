package com.revature.animal;

import com.revature.otherpackage.Something;

public class JavaBasics {

	public static void main(String[] args) {
		// line
		/*
		 * block comment
		 */

		System.out.println("Hello!");

		// primitive types
		boolean bool = true; // size is JVM-dependent
		short s;
		byte b;
		int i; // declaring a variable
		i = 2; // initializing
		long l;
		char c;
		float f = 1.5f;
		double d = 12.2;

		// reference types
		// wrappers are reference-type versions of primitives - usually come with
		// methods as well
		Integer in;
		Double dou;
		Boolean boo;
		Float fl = f;
		Long lo;
		Byte by;
		Short sh;
		Character ch;

		// Objects
		JavaBasics jb = new JavaBasics();
		// Strings
		String string = "String 1";
		String string2 = new String("String2");

		// instantiates an animal of age = 5
		Animal dog = new Animal(5);
		dog.makeNoise();

		Something some = new Something();
		// Arrays
		Animal[] animals = new Animal[5];
		Animal[] animals2 = { dog, new Animal() };

		for (int i1 = 0; i1 < 5; i1++) {
			System.out.println(animals[i]);
		}

		int j = 0;
		while (j < animals2.length) {
			animals2[j].makeNoise();
			j++;
		}

		for (Animal anima : animals2) {
			anima.makeNoise();
		}

		int x = 1;

		if (x > 0) {
			System.out.println("x is greater than 0.");
		} else {
			System.out.println("x is smaller than or equal to 0.");
		}

		do {
			System.out.println("In the do while loop");
			x--;
		} while (x > 0);

		switch (x) {
		case 0:
			System.out.println("It's 0");
			break;
		case 1:
			System.out.println("It's 1");
			break;
		default:
			System.out.println("Default case.");
			break;
		}
	}
}
