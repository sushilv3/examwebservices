package com.kodecamp.examwebservices.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodecamp.examwebservices.model.User;
import com.kodecamp.examwebservices.model.UserRole;
import com.kodecamp.examwebservices.repo.RoleRepository;
import com.kodecamp.examwebservices.repo.UserRepository;
import com.kodecamp.examwebservices.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	// creating user with there roles
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUsername(user.getUsername());
		if (local != null) {
			System.out.println("User is already there !!");
			throw new Exception("User is already present !!");
		} else {
			// create user

			// save user roles
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}

	// getting user by username
	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);

	}

//delete user by id
	@Override
	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);

	}

}
