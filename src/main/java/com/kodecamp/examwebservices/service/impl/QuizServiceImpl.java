package com.kodecamp.examwebservices.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodecamp.examwebservices.model.exam.Quiz;
import com.kodecamp.examwebservices.repo.QuizRepository;
import com.kodecamp.examwebservices.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {

		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {

		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizes() {

		return new HashSet<>(quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long qId) {
//find by id returns optional
		return this.quizRepository.findById(qId).get();
	}

	@Override
	public void deleteQuiz(Long qId) {
		Quiz q = new Quiz();
		q.setqId(qId);
		this.quizRepository.delete(q);
	}

}
