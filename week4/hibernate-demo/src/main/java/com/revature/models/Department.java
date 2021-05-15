package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@NamedQueries({
		@NamedQuery(name="getAllNq", query="from Department")
})
public class Department implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_id")
	private Integer id;
	@Column(nullable = false, unique = true)
	private String name;
	
	private Double monthlyBudget;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(Integer id, String name, Double monthlyBudget) {
		super();
		this.id = id;
		this.name = name;
		this.monthlyBudget = monthlyBudget;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMonthlyBudget() {
		return monthlyBudget;
	}
	public void setMonthlyBudget(Double monthlyBudget) {
		this.monthlyBudget = monthlyBudget;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((monthlyBudget == null) ? 0 : monthlyBudget.hashCode());
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
		Department other = (Department) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (monthlyBudget == null) {
			if (other.monthlyBudget != null)
				return false;
		} else if (!monthlyBudget.equals(other.monthlyBudget))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", monthlyBudget=" + monthlyBudget + "]";
	}
	
	
}
