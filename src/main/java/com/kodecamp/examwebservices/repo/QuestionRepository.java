package com.kodecamp.examwebservices.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodecamp.examwebservices.model.exam.Question;
import com.kodecamp.examwebservices.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	//custom finder method no need to give implimantation (works basis of property)
	Set<Question> findByQuiz(Quiz quiz);

}
