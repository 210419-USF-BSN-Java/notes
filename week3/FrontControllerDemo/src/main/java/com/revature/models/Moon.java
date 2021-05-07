package com.revature.models;

import java.io.Serializable;

public class Moon implements Serializable{
	private int id;
	private String name;
	private Planet planet;
	public Moon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Moon(int id, String name, Planet planet) {
		super();
		this.id = id;
		this.name = name;
		this.planet = planet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((planet == null) ? 0 : planet.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moon other = (Moon) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (planet == null) {
			if (other.planet != null)
				return false;
		} else if (!planet.equals(other.planet))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Moon [id=" + id + ", name=" + name + ", planet=" + planet + "]";
	}
}
