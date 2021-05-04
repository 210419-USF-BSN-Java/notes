package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {

	private EmployeeDao ed = new EmployeeDao();
	
	public List<Employee> getAllEmployees(){
		return ed.getAllEmployees();
	}
	
	public List<Employee> getEmployeeByUsername(String username){
		return ed.getAllEmployees().stream().filter(e->e.getUsername().equals(username)).collect(Collectors.toList());
	}
	
	public Employee getEmployeeById(int id) {
		return ed.getEmployeeById(id);
	}
	
	public int createEmployee(Employee e) {
		return ed.createEmployee(e);
	}
}
