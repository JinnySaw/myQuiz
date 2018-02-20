/**
 * 
 */
package com.jinnysaw.myQuiz.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jinnysaw
 * DateTime 2018Feb07 4:55 PM
 */
@Entity
@Table(name="chapter")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"}, allowGetters= true)
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	private Subject subject;
	
	@OneToMany(mappedBy="chapter", cascade=CascadeType.ALL,fetch= FetchType.LAZY)
	@JsonIgnore
	private List<Question> questions;
	
	@NotBlank
	private String Chapterno;
	@NotBlank
	private String Chaptername;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getChapterno() {
		return Chapterno;
	}
	public void setChapterno(String chapterno) {
		Chapterno = chapterno;
	}
	public String getChaptername() {
		return Chaptername;
	}
	public void setChaptername(String chaptername) {
		Chaptername = chaptername;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
