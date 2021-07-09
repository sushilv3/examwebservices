package com.kodecamp.examwebservices.service;

import java.util.Set;

import com.kodecamp.examwebservices.model.exam.Question;
import com.kodecamp.examwebservices.model.exam.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);

	public Question updateQuestion(Question question);

	public Set<Question> getQuestions();

	public Question getQuestion(Long quesId);

	public void deleteQuestion(Long quesId);

	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public Question get(Long quesId);

}
