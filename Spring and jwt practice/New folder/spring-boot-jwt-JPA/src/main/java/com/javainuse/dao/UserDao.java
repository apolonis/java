package com.javainuse.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.DAOUser;

import java.util.List;


@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

	DAOUser findByUsername(String username);
	DAOUser findByUuid(String uuid);
	DAOUser deleteByUuid(String uuid);
	List<DAOUser> findByName(String name);
	List<DAOUser> findByRole(String role);
}