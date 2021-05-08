package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

/*
 * Using the FC Design pattern, all of the requests have been mapped to this servlet
 */
public class FrontController extends DefaultServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// RequestHelper(RH) is in charge of routing the request to their appropriate delegates based on the request URL
	private RequestHelper rh = new RequestHelper();
	
	//All of the requests (endpoints, HTTP methods) are funneled through this method to be provided to the RH
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		/*
		 * Initially the request URI might look something like: /FrontControllerDemo/planets/1
		 * the URI is cleaned by returning a substring removing "/FrontcontrollerDemo" (the context path)
		 */
		//String url = request.getRequestURI();
		//String contextPath = request.getContextPath();
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		/*
		 * We want to process the request based on the URI, however we still want to be able to return static webpages from the static folder
		 */
		if(path.startsWith("/static/") || path.equals("/") || path.equals("/index.html") ) {
			super.doGet(request, response);
		}else {
			/*
			 * Feeding the request and response object through the Request Handler logic
			 */
			rh.processRequest(request, response);
		}
	}
	
	// We want to make sure that all of the HTTP methods are routed to the same method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
	
}
