package com.kodecamp.examwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodecamp.examwebservices.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);
	

}
