package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Moon;
import com.revature.services.MoonService;

public class MoonDelegate implements Delegatable {
	
	private MoonService ms = new MoonService();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getMethod());
		
		switch(request.getMethod()) {
		case "GET":
			if(request.getQueryString() != null) {
				String query = request.getQueryString().substring(5);
				System.out.println(query);
				List<Moon> moons = ms.getAllMoonsByPlanetName(query);
				PrintWriter pw = response.getWriter();
				pw.write(new ObjectMapper().writeValueAsString(moons));
			} else {
				List<Moon> moons = ms.getAllMoons();
				PrintWriter pw = response.getWriter();
				pw.write(new ObjectMapper().writeValueAsString(moons));
			}
			
			
			
			break;
		case "POST":
			Moon moon = new Moon();
			moon.setId(Integer.parseInt(request.getParameter("id")));
			moon.setName(request.getParameter("name"));
			moon.setPlanet(null);		
			break;
		default:
			break;
		}

	}

}
