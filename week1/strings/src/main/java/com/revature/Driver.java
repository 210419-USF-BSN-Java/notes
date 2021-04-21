package com.revature;

public class Driver {
	public static void main(String[] args) {
		
		String s = "Hello World!";
		String s2 = "Hello World!";
		String s3 = new String("Hello World!");
		
		// s & s2 refer to the same string in the string pool b/c they were declared literally
		System.out.println("s & s2: " + (s==s2));
		System.out.println("s & s2: " + s.equals(s2));
		
		// s & s3 refer to different strings since s3 was created using the new keyword so and instance was created in the heap
		System.out.println("s & s3: " + (s==s3));
		System.out.println("s & s3: " + s.equals(s3));
		
		String s4 = "Hello " + "World!";
		System.out.println("s & s4: " + (s==s4));
		System.out.println("s & s4: " + s.equals(s4));
		
		// The intern method either finds or constructs a string into the string pool and returns a reference to it
		String s5 = s4.intern();
		System.out.println("s & s5: " + (s==s5));
		System.out.println("s & s5: " + s.equals(s5));
		
		System.out.println("s & s5 compare " + s.compareTo(s5));
		System.out.println("s & hello compare " + s.compareTo("hello"));
		
		s5 = s5.concat(" Goodbye!");
		System.out.println(s5);
		
		/*
		 * substrings
		 * replacing
		 * charAt
		 * spliting strings
		 * length/is empty 
		 */
		
		/*
		 *  == vs .equals()
		 *  == - compares stack values, used for primitives
		 *  .equals() - compares values as defined in the class
		 */
		Object a = new Object();
		Object b = new Object();
		
		// Default implementation is of .equals() is ==
		System.out.println("comparing objects: " + a.equals(b));
		System.out.println(a);
		System.out.println(b);
		
		// Stringbuilder/buffer
		StringBuilder sb = new StringBuilder("Hello");
		sb.append(" ");
		sb.append("World!");
		
		String formerSb = sb.toString();
		
		System.out.println(sb);
		System.out.println(formerSb);
		
		StringBuffer sbuf = new StringBuffer();
		// Generally use StringBuilder.
	}
}
