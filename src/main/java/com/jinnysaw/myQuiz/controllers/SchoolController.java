/**
 * 
 */
package com.jinnysaw.myQuiz.controllers;

import java.util.Date;
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

import com.jinnysaw.myQuiz.models.School;
import com.jinnysaw.myQuiz.repositories.SchoolRepository;

/**
 * @author jinnysaw
 * DateTime 2018Feb07 08:12 PM
 */
@RestController
@RequestMapping("/api")
public class SchoolController {
	@Autowired
	SchoolRepository schoolRepository;
	
	// Get All School
	@GetMapping("/school")
	public List<School> getAllSchools(){
		System.out.println("Get All Schools");
		
		return (List<School>) schoolRepository.findAll();
		
	}
	
	// Create School
	@PostMapping("/school")
	public School createSchool(@Valid @RequestBody School school){
//		System.out.println(school.getSchoolname());
		Date date = new Date();
		school.setCreatedAt(date);
		school.setUpdatedAt(date);
		return schoolRepository.save(school);
	}
	@GetMapping("/school/{id}")
	public ResponseEntity<School> getSchoolById(@PathVariable(value="id") Long schoolId){
		
		School school = schoolRepository.findOne(schoolId);
		if(school ==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(school);
	}
	
	// Update a School
		@PutMapping("/school/{id}")
		public ResponseEntity<School> updateSchool(@PathVariable(value="id") Long schoolId, @Valid @RequestBody School schoolDetails){
			
			School school = schoolRepository.findOne(schoolId);
			if(school ==null){
				return ResponseEntity.notFound().build();
			}
	
			school.setSchoolname(schoolDetails.getSchoolname());
			School updateSchool = schoolRepository.save(school);
			return ResponseEntity.ok(updateSchool);
			
		}
		// Delete a School
		@DeleteMapping("/school/{id}")
		public ResponseEntity<School> deleteSchool(@PathVariable(value="id") Long schoolId){
			School school = schoolRepository.findOne(schoolId);
			if(school == null){
				return ResponseEntity.notFound().build();
			}
			schoolRepository.delete(school);
			return ResponseEntity.ok().build();
		}
}
