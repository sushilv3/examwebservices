package com.kodecamp.examwebservices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kodecamp.examwebservices.model.Role;
import com.kodecamp.examwebservices.model.User;
import com.kodecamp.examwebservices.model.UserRole;
import com.kodecamp.examwebservices.service.UserService;

@SpringBootApplication
public class ExamportalwebservicesApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamportalwebservicesApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code");
		
//		User user = new User();
//		user.setFirstName("sushil");
//		user.setLastName("verma");
//		user.setUsername("suno");
//		user.setEmail("sushil@gmail.com");
//		
//		
//		Role role1 = new Role();
//		role1.setRoleId(77L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet = new HashSet<>();
//		
//		UserRole userRole =new UserRole();
//		
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//		
//		User createdUser = this.userService.createUser(user, userRoleSet);
//		
//		System.out.println(createdUser.getUsername());
//		
	
	}

}
