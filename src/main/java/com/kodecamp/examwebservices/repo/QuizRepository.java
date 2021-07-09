package com.kodecamp.examwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodecamp.examwebservices.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
