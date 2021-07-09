package com.kodecamp.examwebservices.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodecamp.examwebservices.model.exam.Quiz;
import com.kodecamp.examwebservices.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	@PutMapping("/")
	public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
		
	}

	
	@GetMapping("/")
	public ResponseEntity<Set<Quiz>> getQuizes(){
		return ResponseEntity.ok(this.quizService.getQuizes());
	}
	
	
	@GetMapping("/{qId}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable("qId") Long qId){
		return ResponseEntity.ok(this.quizService.getQuiz(qId));
	}
	
	@DeleteMapping("/{qId}")
	public void delete(@PathVariable("qId") Long qId) {
		this.quizService.deleteQuiz(qId);
	}
}
