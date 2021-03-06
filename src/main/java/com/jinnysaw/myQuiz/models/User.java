/**
 * 
 */
package com.jinnysaw.myQuiz.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jinnysaw.myQuiz.security.Authority;
import com.jinnysaw.myQuiz.security.UserRole;

/**
 * @author jinnysaw
 *
 */
@Entity
@Table(name="user")
public class User implements UserDetails, Serializable{
	private static final long serialVersionUID = 771321L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	
	private Long all_accoundid;
	
	@Column(name = "email")
	@Email(message = "Please provide a valid Email")
	@NotEmpty(message = "Please provide an email")
	private String email;

	@Column(name = "username")
	@NotEmpty(message = "Please provide your username")
	private String username;
	
	@Column(name = "password", unique = true)
	@Length(min = 5, message = "Your password must have at least 5 characters")
	@NotEmpty(message = "Please provide your password")
	@JsonIgnore
	private String password;

	@Column(name = "enabled")
	@JsonIgnore
	private boolean enabled=true;
	
	@OneToMany(mappedBy="user",cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRoles =new HashSet<>();

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Calendar createdDate;

	public Calendar getCreatedDate() {
		return createdDate;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<GrantedAuthority> authorities =new HashSet<>();
		userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
		return authorities;
	}

	@Override
	public String getPassword() {
		 // TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		 // TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		 // TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		 // TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		 // TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		 // TODO Auto-generated method stub
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Long getAll_accoundid() {
		return all_accoundid;
	}

	public void setAll_accoundid(Long all_accoundid) {
		this.all_accoundid = all_accoundid;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}
	
}
