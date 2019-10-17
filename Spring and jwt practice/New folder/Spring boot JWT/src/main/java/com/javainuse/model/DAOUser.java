package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;

	@Column(unique = true, name = "uuid", nullable = false)
	private String uuid = UUID.randomUUID().toString().toLowerCase();

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name ="role")
	private String role;

	public DAOUser (){ }
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