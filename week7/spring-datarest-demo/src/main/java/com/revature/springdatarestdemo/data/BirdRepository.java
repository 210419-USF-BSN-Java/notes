package com.revature.springdatarestdemo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.springdatarestdemo.models.Bird;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Integer> {

	public List<Bird> findBirdsByCommonName(String commonName);
}
