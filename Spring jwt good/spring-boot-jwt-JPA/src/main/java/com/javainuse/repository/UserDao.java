package com.javainuse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.User;

import java.util.List;


@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByUsername(String username);
	User findByUuid(String uuid);
	String deleteByUuid(String uuid);
	List<User>findByRole(String role);
	List<User>findByName(String name);
    User findById(Long id);
}