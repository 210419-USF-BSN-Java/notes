package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Planet;

public class PlanetDao {

	private List<Planet> planets = new ArrayList<>();
	
	public PlanetDao() {
		planets.add(new Planet(1, "Earth", "Blue"));
		planets.add(new Planet(2, "Mars", "Red"));
		planets.add(new Planet(3, "Chogger", "Silver"));
	}
	
	public List<Planet> getAllPlanets(){
		return planets;
	}
	
	public Planet getPlanetById(int id) {
		for(Planet p: planets) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
}
