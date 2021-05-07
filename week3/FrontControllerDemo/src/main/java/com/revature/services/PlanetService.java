package com.revature.services;

import java.util.List;

import com.revature.daos.PlanetDao;
import com.revature.models.Planet;

public class PlanetService {
	
	private PlanetDao pd = new PlanetDao();
	
	public List<Planet> getAllPlanets(){
		return pd.getAllPlanets();
	}
	
	public Planet getPlanetById(int id) {
		return pd.getPlanetById(id);
	}
}
