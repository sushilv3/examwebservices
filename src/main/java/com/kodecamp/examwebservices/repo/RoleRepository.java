package com.kodecamp.examwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodecamp.examwebservices.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
