package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Planet;
import com.revature.services.PlanetService;

public class PlanetDelegate implements Delegatable {
	
	private PlanetService ps = new PlanetService();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/*
		 * Path received has been stripped of [...]/planets/
		 * If path:
		 * 		- {id}
		 * 			- GET: Return planet of that id
		 * 		- ""
		 * 			- GET: Return all planets
		 * 			- POST: Create a planet
		 */
		String path = (String) request.getAttribute("path");

		if (path == null || path.equals("")) {
			switch (request.getMethod()) {
			case "GET":
				List<Planet> planets = ps.getAllPlanets();
				PrintWriter pw = response.getWriter();
				pw.write(om.writeValueAsString(planets));
				break;
			case "POST":
				Planet p = new Planet();
				p.setName(request.getParameter("name"));
				p.setColor(request.getParameter("color"));
				p.setId(ps.createPlanet(p));
				response.setStatus(201);
				// Optional, just wanted to see that the planet is added, effectively sending a new GET request to /planets
				response.sendRedirect("planets");
				break;
			default:
				response.sendError(400, "Request not supported.");
			}
		} else {
			// Better validation is needed here
			/*
			 * Path params vs Query params: 
			 * 		- Path [...]/{id}
			 * 		- Query [...}?{key}={pair}
			 */
			int planetId = Integer.valueOf(path);
			Planet p = null;

			switch (request.getMethod()) {
			case "GET":
				p = ps.getPlanetById(planetId);
				if (p != null) {
					response.getWriter().write(om.writeValueAsString(p));
				}else {
					response.sendError(404, "Planet not found.");
				}
			case "PUT":
				// logic to update a planet
				break;
			case "DELETE":
				//logic to remove a planet
				break;
			default:
				response.sendError(400, "Method not supported.");
			}
	}

}
}
