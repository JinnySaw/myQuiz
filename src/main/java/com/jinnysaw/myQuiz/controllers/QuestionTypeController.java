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
import org.springframework.web.bind.annotation.RestController;

import com.jinnysaw.myQuiz.models.QuestionType;
import com.jinnysaw.myQuiz.repositories.QuestionTypeRepository;

/**
 * @author jinnysaw
 * DateTime 2018Feb01 02:05 PM
 */
@RestController
@RequestMapping("/api")
public class QuestionTypeController {
	
	@Autowired
	QuestionTypeRepository questionTypeRepository;
	// Get All
	//http://localhost:8080/api/questiontype
	@GetMapping("/questiontype")
	public List<QuestionType> getAllQuestionType(){
		return (List<QuestionType>) questionTypeRepository.findAll();
	}
	// Insert
	@PostMapping("/questionType")
	public QuestionType createQuestionType(@Valid @RequestBody QuestionType questionType){
		return (QuestionType) questionTypeRepository.save(questionType);
		
	}
	// Get By ID
	// http://localhost:8080/api/questiontype/5
	@GetMapping("/questiontype/{id}")
	public ResponseEntity<QuestionType> getQuestionTypeById(@PathVariable(value="id") Long questionTypeId){
		QuestionType questionType = questionTypeRepository.findOne(questionTypeId);
		if(questionType ==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(questionType);
		
	}
	// Update a QuestionType
		@PutMapping("/questiontype/{id}")
		public ResponseEntity<QuestionType> updateQuestionType(@PathVariable(value="id") Long QuestionTypeId, @Valid @RequestBody QuestionType questionTypeDetails){
			
			QuestionType questionType = questionTypeRepository.findOne(QuestionTypeId);
			if(questionType ==null){
				return ResponseEntity.notFound().build();
			}
			
			questionType.setQuestiontypename(questionTypeDetails.getQuestiontypename());
			questionType.setIsActive(questionTypeDetails.getIsActive());
			questionType.setCreatedAt(questionTypeDetails.getCreatedAt());
			questionType.setUpdatedAt(questionTypeDetails.getUpdatedAt());
			QuestionType updateQuestionType = questionTypeRepository.save(questionType);
			
			return ResponseEntity.ok(updateQuestionType);
			
		}
		// Delete a QuestionType
		@DeleteMapping("/questionType/{id}")
		public ResponseEntity<QuestionType> deleteQuestionType(@PathVariable(value="id") Long questionTypeId){
			QuestionType questionType = questionTypeRepository.findOne(questionTypeId);
			if(questionType == null){
				return ResponseEntity.notFound().build();
			}
			questionTypeRepository.delete(questionType);
			return ResponseEntity.ok().build();
		}
	
}
