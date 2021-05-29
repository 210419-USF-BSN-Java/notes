package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findUserByUsernameAndPassword(String username, String password);
	public User findUserByUsername(String username);
	public User findUserById(Integer id);
}
