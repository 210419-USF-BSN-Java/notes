package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeServlet extends HttpServlet {

	/*
	 * To create servlet class(to handle HTTP requests): - extends HTTPServlet -
	 * override doXXX methods for wanted behaviors - map the endpoint in the web.xml
	 */

	private EmployeeService es = new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("service method was called: " + request.getMethod() + " to " + request.getRequestURI());
		String usernameParam = request.getParameter("username");

		List<Employee> employees;

		if (usernameParam != null) {
			System.out.println("get request to /employees with a username param of " + usernameParam);
			employees = es.getEmployeeByUsername(usernameParam);
		} else {
			System.out.println("get request to /employees with no username param ");
			employees = es.getAllEmployees();
		}

		/*
		 * { //employee info }
		 */
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		pw.write(om.writeValueAsString(employees));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Employee e = new Employee();
		e.setUsername(username);
		e.setPassword(password);

		if(username == null || password == null || es.createEmployee(e) == 0 ) {
		response.setStatus(400);
		}else {
		response.setStatus(201);
		}

		// BufferedReader br = request.getReader();
		// String employeeJson = br.readLine();
		// ObjectMapper om = new ObjectMapper();
		// Employee e = om.readValue(employeeJson, Employee.class);
		// if (es.createEmployee(e) > 0) {
		// 	response.setStatus(201);
		// } else {
		// 	response.setStatus(400);
		// }
	}
}
