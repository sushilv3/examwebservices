package com.kodecamp.examwebservices.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodecamp.examwebservices.model.Role;
import com.kodecamp.examwebservices.model.User;
import com.kodecamp.examwebservices.model.UserRole;
import com.kodecamp.examwebservices.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

//	creating user

	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {

		Set<UserRole> roles = new HashSet<>();

		Role role = new Role();
		role.setRoleId(78L);
		role.setRoleName("NORMAL");

		UserRole userRole = new UserRole();

		userRole.setUser(user);
		userRole.setRole(role);

		roles.add(userRole);

		return this.userService.createUser(user, roles);

	}

	// get User by username
	@GetMapping("/{username}")
	public User getuser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}

	// delete user by id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {

		this.userService.deleteUser(userId);
	}
}
