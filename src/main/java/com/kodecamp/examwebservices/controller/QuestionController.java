package com.kodecamp.examwebservices.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodecamp.examwebservices.model.exam.Question;
import com.kodecamp.examwebservices.model.exam.Quiz;
import com.kodecamp.examwebservices.service.QuestionService;
import com.kodecamp.examwebservices.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}

	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}

	// get all question of any Quiz

	@GetMapping("/quiz/{qId}")
	public ResponseEntity<List<Question>> getQuestionsOfQuiz(@PathVariable("qId") Long qId) {
		System.out.println("************************************");

//		Quiz q = new Quiz();
//		q.setqId(qId);
//		
//		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(q);
//		return ResponseEntity.ok(questionsOfQuiz);
		Quiz quiz = this.quizService.getQuiz(qId);
		Set<Question> questions = quiz.getQuestions();
		List<Question> list = new ArrayList<>(questions);

		if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}

	// get single question
	@GetMapping("/{quesId}")
	public Question getQuestion(@PathVariable("quesId") Long quesId) {
		return this.questionService.getQuestion(quesId);
	}

	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable("quesId") Long quesId) {
		this.questionService.deleteQuestion(quesId);
	}

	// evaluate quiz
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions) {
		System.out.println("****************** : " + questions);
		
		double marksGot=0;
		int correctAnswer=0;
		int attempted = 0;
		
		for(Question q : questions ){
			// System.out.println(q.getGivenAnswer());

			Question question = this.questionService.get(q.getQuesId());
			
			if (question.getAnswer().equals(q.getGivenAnswer())) {
				correctAnswer++;
				
				double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
				
				marksGot +=marksSingle;
			}
			if( q.getGivenAnswer() != null || !q.getGivenAnswer().equals("") ) {
				attempted++;
			}
		}
		Map<String,Object> map = Map.of("marksGot",marksGot,"correctAnswer",correctAnswer,"attempted",attempted );
		return ResponseEntity.ok(map);
	}

}
