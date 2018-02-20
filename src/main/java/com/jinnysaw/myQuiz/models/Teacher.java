/**
 * 
 */
package com.jinnysaw.myQuiz.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author jinnysaw
 * Datetime 2018Feb10 10:17 AM
 */
@Entity
@Table(name="teacher")
public class Teacher implements Serializable{
	private static final long serialVersionUID = 771321L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@NotBlank
	private String Teachername;
	
	private String Phonenumber;
	
	private String Email;
	
	private String Address;
	
	@ManyToOne
	private School teacher_school;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeacherName() {
		return Teachername;
	}

	public void setTeacherName(String teacherName) {
		Teachername = teacherName;
	}

	public String getPhoneNumber() {
		return Phonenumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		Phonenumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTeachername() {
		return Teachername;
	}

	public void setTeachername(String teachername) {
		Teachername = teachername;
	}

	public String getPhonenumber() {
		return Phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}

	public School getTeacher_school() {
		return teacher_school;
	}

	public void setTeacher_school(School teacher_school) {
		this.teacher_school = teacher_school;
	}

	
}
