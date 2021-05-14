package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class UserDaoImpl implements UserDao {
	
	private List<User> users = new ArrayList<>();
	
	public UserDaoImpl() {
		super();
		users.add(new User(1, "user1", "pass1", "admin"));
		users.add(new User(2, "user2","pass2","maintener"));
		users.add(new User(3, "user3", "pass3", "visitor"));
		users.add(new User(4, "user4", "pass4", "visitor"));
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<>(users);
	}

	@Override
	public User getById(int id) {
		for(User u: users) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		for(User u: users) {
			if(u.getUsername() != null && u.getUsername().equals(username)) {
				if(u.getPassword() != null && u.getPassword().equals(password)) {
					return u;
				}
			}
		}
		return null;
	}
}
