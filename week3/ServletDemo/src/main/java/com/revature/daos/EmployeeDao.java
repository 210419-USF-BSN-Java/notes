package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;

public class EmployeeDao {

	private List<Employee> employees = new ArrayList<>();
	
	public EmployeeDao() {
		employees.add(new Employee(0, "andrew", "andrewPass"));
		employees.add(new Employee(1, "kevin", "kevinPass"));
		employees.add(new Employee(2, "nolan", "nolanPass"));
		employees.add(new Employee(3, "dev", "devPass"));
	}
	
	public List<Employee> getAllEmployees(){
		return employees;
	}
	
	public Employee getEmployeeById(int id) {
		for(Employee emp:employees) {
			if(emp.getId()==id) {
				return emp;
			}
		}
		return null;
	}
	
	public int createEmployee(Employee e) {
		int maxId = 0;
		for(Employee emp : employees) {
			if(emp.getId()>maxId) {
				maxId = emp.getId();
			}
		}
		e.setId(maxId+1);
		employees.add(e);
		return maxId+1;
	}
}
