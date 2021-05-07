package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoonDelegate implements Delegatable{

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/*
		 * Path received has been stripped of [...]/moons
		 * 
		 * If path:
		 * 		- ""
		 * 			- GET: Return all moons
		 * 			- POST: Create a new moon
		 * 		- planet/{name}
		 * 			- GET: Return moons of that planet name
		 * 		- {id}
		 * 			- GET: Return moon of that id
		 */
		String path = (String) request.getAttribute("path");
		
	}

}
