package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.UserRepository;
import com.revature.models.User;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:4200")
public class AuthController {

	private UserRepository userRepo;

	@Autowired
	public AuthController(UserRepository repo) {
		this.userRepo = repo;
	}
	
	@DeleteMapping
	public ResponseEntity<Void> invalidateSession(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<User> authenticate(@RequestBody User u, HttpServletRequest req) {
		User authUser = userRepo.findUserByUsernameAndPassword(u.getUsername(), u.getPassword());
		if (authUser != null) {
			HttpSession userSession = req.getSession();
			userSession.setAttribute("authUser", authUser);
			return new ResponseEntity<User>(authUser, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping
	public ResponseEntity<User> checkLogin(HttpSession session) {
		User authUser = (User) session.getAttribute("authUser");
		if (authUser == null) {
			return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
		} 
		return new ResponseEntity<User>(authUser, HttpStatus.OK);
	}

}
