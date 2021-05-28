package com.revature.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Secured;
import com.revature.data.UserRepository;
import com.revature.models.User;
import com.revature.models.UserRole;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	private UserRepository userRepo;

	@Autowired
	public UserController(UserRepository repo) {
		this.userRepo = repo;
	}

	@Secured(allowedRoles={"ADMIN", "DEV"})
	@GetMapping
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@PostMapping
	public ResponseEntity<String> registerNewUser(@Valid @RequestBody User newUser) {
		if (userRepo.findUserByUsername(newUser.getUsername()) != null) {
			return new ResponseEntity<String>("Username already exists", HttpStatus.BAD_REQUEST);
		}
		newUser.setRole(UserRole.BASIC_USER);
		newUser.setRegisterDateTime(LocalDateTime.now());
		userRepo.save(newUser);
		return new ResponseEntity<String>("User has been created", HttpStatus.CREATED);

	}

	@Secured(allowedRoles={"ADMIN", "DEV", "BASIC_USER"})
	@PutMapping
	public ResponseEntity<String> updateUser(@Valid @RequestBody User updatedUser, HttpSession session) {
		User upUser = userRepo.findUserById(((User) session.getAttribute("authUser")).getId());
		if(updatedUser.getUsername().equals(upUser.getUsername())) {
			updatedUser.setId(upUser.getId());
			userRepo.save(updatedUser);
			session.setAttribute("authUser", updatedUser);
			return new ResponseEntity<String>("User updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Invalid request", HttpStatus.BAD_REQUEST);
		}
	}

}
