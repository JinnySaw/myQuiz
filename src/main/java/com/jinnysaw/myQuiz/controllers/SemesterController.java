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
import com.jinnysaw.myQuiz.models.Semester;
import com.jinnysaw.myQuiz.repositories.SemesterRepository;

/**
 * @author jinnysaw DateTime 2018Feb07 08:41 PM
 */
@RestController
@RequestMapping("/api")
public class SemesterController {

	@Autowired
	SemesterRepository semesterRepository;

	// Get All Semester
	// This method is pretty straightforward. It calls JpaRepository’s findAll()
	// method to retrieve all the notes from the database and returns the entire
	// list.
	// The @GetMapping("/") annotation is a short form of
	// @RequestMapping(value="/notes", method=RequestMethod.GET).
	@GetMapping("/Semester")
	public List<Semester> getAllSemester() {
		System.out.println("Get All Semesterzes");
		return (List<Semester>) semesterRepository.findAll();

	}

	// Create a new Semester
	// The @RequestBody annotation is used to bind the request body with a
	// method parameter.
	// The @Valid annotation makes sure that the request body is valid.
	// Remember, we had marked Semester's title and content with @NotBlank
	// annotation in the Note model?
	// If the request body doesn’t have a title or a content, then spring will
	// return a 400 BadRequest error to the client.
	@PostMapping("/semester")
	public Semester createSemester(@Valid @RequestBody Semester semester) {
		return semesterRepository.save(semester);
	}

	// Get a Single Semester
	// The @PathVariable annotation, as the name suggests, is used to bind a
	// path variable with a method parameter.
	// In the above method, we are returning a ResponseEntity<Semester> instead
	// of Semester. The ResponseEntity class gives us more flexibility while
	// returning a response from the api.
	// For example, in the above api, If a Semester doesn’t exist with the given
	// id, then we’re returning a 404 Not Found error with the help of
	// ResponseEntity.
	@GetMapping("/Semester/{id}")
	public ResponseEntity<Semester> getSemesterById(@PathVariable(value = "id") Long SemesterId) {

		Semester Semester = semesterRepository.findOne(SemesterId);
		if (Semester == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(Semester);
	}

	// Update a Semester
	@PutMapping("/Semester/{id}")
	public ResponseEntity<Semester> updateSemester(@PathVariable(value = "id") Long SemesterId,
			@Valid @RequestBody Semester semesterDetails) {

		Semester Semester = semesterRepository.findOne(SemesterId);
		if (Semester == null) {
			return ResponseEntity.notFound().build();
		}

		Semester.setSemestername(semesterDetails.getSemestername());
		// Semester.se(semesterDetails.getDescription());
		// //Semester.setCreatedAt(SemesterDetails.getCreatedAt());
		// Semester.setUpdatedAt(SemesterDetails.getUpdatedAt());
		Semester updateSemester = semesterRepository.save(Semester);
		// ee
		return ResponseEntity.ok(updateSemester);

	}

	// Delete a Semester
	@DeleteMapping("/Semester/{id}")
	public ResponseEntity<Semester> deleteSemester(@PathVariable(value = "id") Long semesterId) {
		Semester Semester = semesterRepository.findOne(semesterId);
		if (Semester == null) {
			return ResponseEntity.notFound().build();
		}
		semesterRepository.delete(Semester);
		return ResponseEntity.ok().build();
	}
}