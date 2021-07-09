package com.kodecamp.examwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodecamp.examwebservices.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
