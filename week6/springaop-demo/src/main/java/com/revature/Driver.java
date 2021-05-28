package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		User u = ac.getBean(User.class);
		
		u.setName("Robbie");
		u.setSleepy(false);
		u.doWork();
	}

}
