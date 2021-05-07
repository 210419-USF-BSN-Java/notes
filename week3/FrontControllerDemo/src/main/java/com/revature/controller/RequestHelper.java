package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.MoonDelegate;
import com.revature.delegates.PlanetDelegate;

public class RequestHelper {

	/*
	 * route the request to the appropriate delegate
	 */
	PlanetDelegate pd = new PlanetDelegate();
	MoonDelegate md = new MoonDelegate();

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		String query = request.getQueryString();
		System.out.println("Query string: " + query);
		
		switch (path) {
		case "/moons":
			/*
			 * methods: - POST - Create a moon 
			 * 			- Get - Get all moons
			 * 
			 */
			System.out.println("in /moons");
			md.process(request, response);
			break;
		case "/planets":
			/*
			 * methods: - Get - Get all planets
			 */
			System.out.println("in /planets");
			pd.process(request, response);
			break;
		default:
			response.sendError(404, "Path not supported");
		}
	}
}
