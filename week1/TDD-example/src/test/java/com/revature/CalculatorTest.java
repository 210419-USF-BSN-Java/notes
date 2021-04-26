package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.exceptions.EvenNumberException;
import com.revature.interfaces.Calculatable;
import com.revature.models.Calculator;

public class CalculatorTest {

	private static Calculatable calc;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("@BeforeClass is ran ONCE before everything else in the class");
		calc = new Calculator();
	}
	
	@Before
	public void beforeEach() {
		System.out.println("@Before gets executed before each tests");
	}
	
	@After
	public void afterEach() {
		System.out.println("@After gets executed after each tests");
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("@AfterClass is ran ONCE after everything else in the class");
		// used to close resources
	}
	
	@Test
	public void testInstantiation() {
		assertNotNull(calc);
	}
	
	@Test
	public void testAdd5() {
		assertEquals(5, calc.add(2, 3),0.001);
	}
	
	@Test(expected = EvenNumberException.class)
	public void testAddException() {
		calc.add(1, 1);
	}
}
