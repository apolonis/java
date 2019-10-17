package com.javainuse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.DAOUser;

import java.util.List;


@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

	DAOUser findByUsername(String username);
	DAOUser findByUuid(String uuid);
	String deleteByUuid(String uuid);
	List<DAOUser>findByRole(String role);
	List<DAOUser>findByName(String name);

    DAOUser findById(Long id);
}