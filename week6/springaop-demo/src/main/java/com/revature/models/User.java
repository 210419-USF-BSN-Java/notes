package com.revature.models;

import org.springframework.stereotype.Component;

import com.revature.exceptions.RobbieException;

@Component
public class User {
	private String name;
	private boolean isSleepy;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isSleepy ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		User other = (User) obj;
		if (isSleepy != other.isSleepy)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSleepy() {
		return isSleepy;
	}
	public void setSleepy(boolean isSleepy) {
		this.isSleepy = isSleepy;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", isSleepy=" + isSleepy + "]";
	}
	
	public void doWork() {
		if(isSleepy) {
			throw new RobbieException();
		} else {
			System.out.println(name + " is doing work!");
		}
	}
}
