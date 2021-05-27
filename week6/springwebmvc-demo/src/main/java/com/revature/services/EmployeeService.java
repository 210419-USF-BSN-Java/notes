package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.EmployeeNotFoundException;
import com.revature.models.Employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    private List<Employee> employees = new ArrayList<>();
    
    public EmployeeService(){
        employees.add(new Employee(1, "Bob", "Director"));
        employees.add(new Employee(2, "Sally", "SubDirector"));
        employees.add(new Employee(3, "Jenkins", "SubDirector"));
    }

    public List<Employee> getAll(){
        return employees;
    }

    public Employee getEmployeeById(int id){
        for(Employee e: employees){
            if(e.getId() == id){
                return e;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public void createEmployee(Employee e){
        employees.add(e);
    }
    
    public List<Employee> getEmployeeByPosition(String position){
    	List<Employee> pEmployees = new ArrayList<>();
        for(Employee e: employees){
            if(e.getPosition().equals(position)){
               pEmployees.add(e);
            }
        }
        return pEmployees;
    }
    
}
