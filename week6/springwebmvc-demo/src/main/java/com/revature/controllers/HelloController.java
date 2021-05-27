package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping(method=RequestMethod.GET, value="/home")
	public String hello() {
		return "home";
	}

	@RequestMapping(method=RequestMethod.GET, value="/home2")
	@ResponseBody
	public String hello2() {
		return "home";
	}
}
