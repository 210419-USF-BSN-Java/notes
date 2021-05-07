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
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getMethod());
		switch (request.getMethod()) {
			case "GET":
				List<Planet> planets = ps.getAllPlanets();
				PrintWriter pw = response.getWriter();
					pw.write(new ObjectMapper().writeValueAsString(planets));
				break;
			case "POST":
				// logic to add a planet
				Planet planet = new Planet();
				planet.setId(Integer.parseInt(request.getParameter("id")));
				planet.setName(request.getParameter("name"));
				planet.setColor(request.getParameter("color"));
				break;
			default:
				response.sendError(400, "Request not supported.");
				break;
		}
	}

}
