package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {

	public List<User> getAll();
	public User getById(int id);
	public User getUserByUsernameAndPassword(String username, String password);
	
	
}
