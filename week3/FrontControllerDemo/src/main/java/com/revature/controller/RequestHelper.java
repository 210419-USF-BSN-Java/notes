package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.MoonDelegate;
import com.revature.delegates.PlanetDelegate;

public class RequestHelper {

	PlanetDelegate pd = new PlanetDelegate();
	MoonDelegate md = new MoonDelegate();

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		StringBuilder uriString = new StringBuilder(request.getRequestURI());
		// uriString = /FrontControllerDemo/planets/1

		/*
		 *  in order to map it to the appropriate handler, we need to get the relevant path
		 */
		uriString.replace(0, request.getContextPath().length() + 1, "");
		// uriString = planets/1

		if (uriString.indexOf("/") != -1) {
			/*
			 * Here we set an attribute 'path' to be used in the delegates for additional information, ie: retrieve by id
			 */
			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));
			// path = 1, planets has been removed
			
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
			// at this point, uriString = planets
		}

		/*
		 * Based on the uriString, the request/response are then routed to the appropriate delegate
		 */
		switch (uriString.toString()) {
		case "moons":
			md.process(request, response);
			break;
		case "planets":
			pd.process(request, response);
			break;
		default:
			response.sendError(404, "Path not supported");
		}
	}
}
