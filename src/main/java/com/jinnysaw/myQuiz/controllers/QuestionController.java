/**
 * 
 */
package com.jinnysaw.myQuiz.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jinnysaw.myQuiz.models.Answer;
import com.jinnysaw.myQuiz.models.Question;
import com.jinnysaw.myQuiz.models.QuestionType;
import com.jinnysaw.myQuiz.repositories.AnswerRepository;
import com.jinnysaw.myQuiz.repositories.QuestionRepository;
import com.jinnysaw.myQuiz.repositories.QuestionTypeRepository;

/**
 * @author jinnysaw
 * DateTime 2018Feb04 07:18 PM
 *
 */
@RestController
@RequestMapping("/api")
public class QuestionController {
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	private QuestionTypeRepository qestionTypeRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@GetMapping("/question")
	public List<Question> getAllQuestion(){
		return (List<Question>) questionRepository.findAll();
	}
	
	// Create Question
	@PostMapping("/question")
	public Question createQuestion(@Valid @RequestBody Question question, @RequestParam long questionTypeId){
		
		QuestionType qType =  qestionTypeRepository.findOne(questionTypeId);
		question.setQuestionType(qType);
		return questionRepository.save(question);
	}
	
	// Get a Single Question
	@GetMapping("/question/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable(value="id") Long questionId){
		Question question = questionRepository.findOne(questionId);
		if(question == null){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(question);
		
	}
	
	// Updaete a Question
	@PutMapping("/question/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable(value="id") Long questionId, @Valid @RequestBody Question questionDetails){
		Question question = questionRepository.findOne(questionId);
				if(question == null){
					return ResponseEntity.notFound().build();
				}
				
				question.setQuestiontext(questionDetails.getQuestiontext());
				question.setQuestionType(questionDetails.getQuestionType());
				question.setOrder(questionDetails.getOrder());
				question.setUpdatedAt(questionDetails.getUpdatedAt());
				Question updateQuestion = questionRepository.save(question);
				
				
		return ResponseEntity.ok(updateQuestion);
		
	}
	
	// Delete a Question
	@DeleteMapping("/question/{id}")
	public ResponseEntity<Question> deleteQuestion(@PathVariable(value="id") Long questionId){
		Question question = questionRepository.findOne(questionId);
		if(question ==null){
			return ResponseEntity.notFound().build();
		}
		
		questionRepository.delete(question);
		return ResponseEntity.ok().build();
	}
	
	// Get all answers by questionId
	@GetMapping("/question/{id}/answers")
	public List<Answer> findAnswers(@PathVariable Long question_id){
		Question question = questionRepository.findOne(question_id);
				return answerRepository.findByQuestionOrderByOrderAsc(question);
	}
}

