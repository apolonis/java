package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	@NotEmpty(message = "Please enter a valid username")
	private String username;
	@Column
	@JsonIgnore
	@NotEmpty(message = "Please enter a valid password")
	private String password;

	@Column(unique = true, name = "uuid", nullable = false)
	private String uuid = UUID.randomUUID().toString().toLowerCase();

	@NotEmpty(message = "Please enter a valid name")
	@NotNull(message = "Name may not be null")
	@Column(unique = true, name = "name")
	private String name;

	@NotEmpty(message = "Please enter a valid lastname")
	@Column(name = "lastname")
	private String lastname;

	@NotEmpty(message = "Please enter a valid email adress")
	@Column(unique = true, name = "email")
	private String email;

	@NotEmpty(message = "Please enter a valid role")
	@Column(name ="role")
	private String role;

	public User(){ }
	public String getRole() { return role; }

	public void setRole(String role) { this.role = role; }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUuid() {
		return uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}