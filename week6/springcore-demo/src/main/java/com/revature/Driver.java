package com.revature;

import java.io.PrintWriter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Department;
import com.revature.models.Employee;

public class Driver {

//	@Bean
//	public PrintWriter getPrinter() {
//		return new PrintWriter();
//	}
	
	public static void main(String[] args) {
		Department d = new Department();
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Department d1 = (Department) ac.getBean("department");
		Department d2 = (Department) ac.getBean("department");
		
		// Requested bean is a singleton is scope is defined as a singleton
		System.out.println("Requesting the same instance of a bean: " + (d1 == d2));
		
		Employee e = (Employee) ac.getBean("employee");
		System.out.println(e);
	}
}
