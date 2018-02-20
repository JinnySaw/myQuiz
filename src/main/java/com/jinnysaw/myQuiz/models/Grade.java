/**
 * 
 */
package com.jinnysaw.myQuiz.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jinnysaw
 * DateTime: 2018Feb06 11:01 AM
 */
@Entity
@Table(name="grade")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"}, allowGetters= true)
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String Gradeno;
	
	@NotBlank
	private String Gradename;
	
	@ManyToOne
	@JsonIgnore
	private Level level;
	
	@OneToMany(mappedBy="grade", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	@JsonIgnore
	private List<Course> courses; 
	
	@OneToMany(mappedBy="grade", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	@JsonIgnore
	private List<Class> classes;
	
	@OneToMany(mappedBy ="grade", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	@JsonIgnore
	private List<Subject> subjects;
	
	@Column(nullable=false, updatable =false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(nullable =false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getGradeno() {
		return Gradeno;
	}

	public void setGradeno(String gradeno) {
		Gradeno = gradeno;
	}

	public String getGradename() {
		return Gradename;
	}

	public void setGradename(String gradename) {
		Gradename = gradename;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}
	
	
}
