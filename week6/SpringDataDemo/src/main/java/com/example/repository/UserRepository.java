package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{

	User findUserByUsernameOrEmail(String username, String email);
	
	//bad practice, just an example
	@Transactional(isolation=Isolation.SERIALIZABLE)
	User findUserByUsernameAndPassword(String username, String password);
	
	@Query("SELECT u FROM User u WHERE u.loggedOn = true")
	List<User> findAllLoggedOnUsers();
}
