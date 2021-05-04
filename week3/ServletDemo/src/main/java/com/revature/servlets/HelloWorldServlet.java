package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{

	public void init(ServletConfig config) {
		System.out.println("init was called.");
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("service method was called: " + request.getMethod() + " to " + request.getRequestURI());
		PrintWriter pw = response.getWriter();
		pw.write("<h1>Hello World</h1>");
		
		/*
		 * switch(request.getMethod){
		 * 		case "GET":
		 * 			// call doGet
		 * 		case "POST:
		 * 			// call doPost
		 * 
		 * }
		 */
	
	}
	
	public void destroy() {
		System.out.println("destroy was called");
	}
}
