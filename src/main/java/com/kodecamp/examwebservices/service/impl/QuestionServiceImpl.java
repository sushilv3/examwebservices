package com.kodecamp.examwebservices.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodecamp.examwebservices.model.exam.Question;
import com.kodecamp.examwebservices.model.exam.Quiz;
import com.kodecamp.examwebservices.repo.QuestionRepository;
import com.kodecamp.examwebservices.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
	
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long quesId) {
		
		return this.questionRepository.findById(quesId).get();
	}

	@Override
	public void deleteQuestion(Long quesId) {
		Question q = new Question();
		q.setQuesId(quesId);
		this.questionRepository.delete(q);
		
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {

		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public Question get(Long quesId) {
		
		return this.questionRepository.getById(quesId);
	}

}
