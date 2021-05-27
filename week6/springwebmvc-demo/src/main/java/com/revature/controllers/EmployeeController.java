package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

//@Controller
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService es;

    // @RequestMapping(method=RequestMethod.GET)
    @GetMapping
//    @ResponseBody
    public List<Employee> getAllEmployees(@RequestParam(name="position", required=false)String position){
		if(position!=null) {
			return es.getEmployeeByPosition(position);
		}
    	return es.getAll();
    }
    
	@GetMapping("/{id}")
//	@ResponseBody
	public Employee getEmployeeById(@PathVariable("id")int id) {
		return es.getEmployeeById(id);
	}
	
//	@GetMapping("/{id}")
//	@ResponseBody
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")int id) {
//		return new ResponseEntity<>(es.getEmployeeById(id),HttpStatus.OK);
//	}
	

//	@PostMapping
//	@ResponseBody
//	@ResponseStatus(value=HttpStatus.CREATED)
//	public String addEmployee(@RequestParam("id")int id, @RequestParam("name")String name, @RequestParam("position")String position) {
//		Employee e = new Employee(id, name,  position);
//		es.createEmployee(e);
//		return "added employee "+e.getName();
//	}
	
	
//	@PostMapping("/employees")
//	@ResponseBody
//	public String addEmployee(HttpServletRequest request, HttpServletResponse response) {
//		// access params in request and send status code with response
//		// ie: a way to handle sessions
//		return "added employee";
//	}
	
	
	@PostMapping
//	@ResponseBody
	public ResponseEntity<String> addEmployee(@RequestBody Employee e) {
		es.createEmployee(e);
		return new ResponseEntity<>("added employee "+e.getName(),HttpStatus.CREATED);
	}
	
}
