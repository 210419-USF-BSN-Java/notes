package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.daos.MoonDao;
import com.revature.models.Moon;

public class MoonService {

	private MoonDao md = new MoonDao();
	
	public List<Moon> getAllMoons(){
		return md.getAllMoons();
	}
	
	public Moon getMoonById(int id) {
		return md.getMoonById(id);
	}
	
	public int createMoon(Moon moon) {
		return md.createMoon(moon);
	}
	
	public List<Moon> getAllMoonsByPlanetName(String name){
		return md.getAllMoons().stream().filter(m->m.getPlanet().getName().equals(name)).collect(Collectors.toList());
		
	}
}
