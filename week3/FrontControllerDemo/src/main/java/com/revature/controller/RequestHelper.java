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
		//Using Query params
		//-----------------------------------------------------------------------------------------
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		//returns uri after the main controller (/FrontController). Does not include query params
		String query = request.getQueryString();
		//Gets query params, but can become confusing with multiple query params
		//REST doesn't use query params
		System.out.println("Query string: " + query);
		
		//Using set attribute
		//-----------------------------------------------------------------------------------------
		StringBuilder uriString = new StringBuilder(request.getRequestURI());
		// /FrontController/planets/...
		uriString.replace(0, request.getContextPath().length() + 1, "");
		// planets/...
		if(uriString.indexOf("/") != -1) {
			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));
			//puts the path info after planets/ into an attribute called "path" for later use
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
			//shaves of the extra path info that was already stored. Just leaving planets
			
		}
		
		switch (uriString.toString()) {
		case "moons":
			/*
			 * methods: - POST - Create a moon 
			 * 			- Get - Get all moons
			 * 
			 */
			System.out.println("in moons");
			md.process(request, response);
			break;
		case "planets":
			/*
			 * methods: - Get - Get all planets
			 */
			System.out.println("in planets");
			pd.process(request, response);
			break;
		default:
			response.sendError(404, "Path not supported");
		}
	}
}
