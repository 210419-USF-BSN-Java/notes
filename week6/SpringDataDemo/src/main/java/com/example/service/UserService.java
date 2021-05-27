package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	private UserRepository uRepo;
	
	public UserService() {
		
	}
	
	@Autowired
	public UserService(UserRepository repo) {
		this.uRepo = repo;
	}
	
	public String registerUser(String email, String username, String password) {
		try {
			uRepo.save(new User(email, username, password));
			return "User created successfully";
		} catch(Exception e) {
			return "User was not created successfully";
		}
	}
	
	public String loginUsername(String username, String password) {
		try {
			User loggedIn = uRepo.findUserByUsernameAndPassword(username, password);
			if(loggedIn == null) {
				return "User login failed";
			}
			else {
				loggedIn.setLoggedOn(true);
				uRepo.save(loggedIn);
				return "User logged in successfully";
			}
		}catch(Exception e) {
			return "User login failed";
		}
	}
	
	public User searchUsers(String username, String email) {
		try {
			return uRepo.findUserByUsernameOrEmail(username, email);
		}catch(Exception e) {
			return null;
		}
	}
	
	public List<User> getLoggedOnUsers(){
		return uRepo.findAllLoggedOnUsers();
	}
	
}
