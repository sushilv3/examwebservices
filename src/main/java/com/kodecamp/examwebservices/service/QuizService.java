package com.kodecamp.examwebservices.service;

import java.util.Set;

import com.kodecamp.examwebservices.model.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizes();
	
	public Quiz getQuiz(Long qId);
	
	public void deleteQuiz(Long qId);

}
