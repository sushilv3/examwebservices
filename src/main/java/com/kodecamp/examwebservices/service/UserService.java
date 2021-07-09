package com.kodecamp.examwebservices.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.kodecamp.examwebservices.model.User;
import com.kodecamp.examwebservices.model.UserRole;


public interface UserService {

	//creating user
	
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
//	get user by username
	
	public User getUser(String username);
	
	//delete user by id
	public void  deleteUser(Long id);
}
