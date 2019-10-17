package com.example.demo.Repository;

import com.example.demo.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

	
        List<User>findByUsername(String username);
        List<User>findByEmail(String email);
        //List<User>findAllByArchivedOrderById(String archived);
        List<User>findAll();

    }
