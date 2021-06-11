package com.revature.springdatarestdemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bird {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean hasTongue;
	private String name;
	private String commonName;
	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bird(int id, boolean hasTongue, String name, String commonName) {
		super();
		this.id = id;
		this.hasTongue = hasTongue;
		this.name = name;
		this.commonName = commonName;
	}
	@Override
	public String toString() {
		return "Bird [id=" + id + ", hasTongue=" + hasTongue + ", name=" + name + ", commonName=" + commonName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commonName == null) ? 0 : commonName.hashCode());
		result = prime * result + (hasTongue ? 1231 : 1237);
		result = prime * result + id;
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
		Bird other = (Bird) obj;
		if (commonName == null) {
			if (other.commonName != null)
				return false;
		} else if (!commonName.equals(other.commonName))
			return false;
		if (hasTongue != other.hasTongue)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isHasTongue() {
		return hasTongue;
	}
	public void setHasTongue(boolean hasTongue) {
		this.hasTongue = hasTongue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	
}
