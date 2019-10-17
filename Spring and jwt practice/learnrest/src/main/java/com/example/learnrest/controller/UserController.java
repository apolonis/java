package com.example.learnrest.controller;


import com.example.learnrest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.learnrest.repository.UserRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/all")
    public List<User> getAll() {

        return userRepository.findAll();


    }


    @GetMapping("/hello")
    public String sayHi() {
        return "Hello";
    }



    @PostMapping("/add")
    public String createUser(@Valid @RequestBody User user){
        userRepository.save(user);
        return "Sacuvan je user";
    }

    @PostMapping("/add2")
    public HashMap<String, Object> createUser(@Valid @RequestBody HashMap<String, Object> req){
        String name1 = (String)req.get("trta");
        String name2 = (String)req.get("mrta");

        User user1 = new User();
        user1.setName(name1);
        userRepository.save(user1);

        User user2 = new User();
        user2.setName(name2);
        userRepository.save(user2);

        HashMap<String, Object> res = new HashMap<>();
        res.put("name1", user1.getName());
        res.put("name2", user2.getName());
        return res;
    }






}
