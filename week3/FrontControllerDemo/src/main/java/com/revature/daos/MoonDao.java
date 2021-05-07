package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Moon;

public class MoonDao {

	private List<Moon> moons = new ArrayList<>();
	private PlanetDao pd;
	
	public MoonDao() {
		pd = new PlanetDao();
		moons.add(new Moon(1,"Sheesh", pd.getPlanetById(1)));
		moons.add(new Moon(2,"Europa", pd.getPlanetById(1)));
		moons.add(new Moon(3,"Moon", pd.getPlanetById(2)));
		moons.add(new Moon(4,"Cheese", pd.getPlanetById(3)));
	}
	
	public List<Moon> getAllMoons(){
		return moons;
	}
	
	public Moon getMoonById(int id) {
		for(Moon m : moons) {
			if(m.getId() == id) {
				return m;
			}
		}
		return null;
	}
	
	public int createMoon(Moon moon) {
		int id = 0;
		for(Moon m: moons) {
			if(m.getId() > id) {
				id = m.getId();
			}
		}
		moon.setId(id+1);
		moons.add(moon);
		return id+1;
	}
}
