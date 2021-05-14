package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	public Employee add(Employee e);
	public Employee getById(Integer id);
	public List<Employee> getAll();
	public void update(Employee e);
	public void delete(Employee e);
}
