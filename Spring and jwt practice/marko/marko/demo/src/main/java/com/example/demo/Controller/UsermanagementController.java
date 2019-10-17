package com.example.demo.Controller;


import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Comparator;
import java.util.List;

//Im creating this clas to get mapping(connect) java with html doc
//Function created must return the page they needed

@Controller
public class  UsermanagementController {
	
    @Autowired
    UserRepository repository;

    @Autowired
    private UserService userService;
    
    @GetMapping("/userManagement")
    public String getUserManagement(Model model){
        List<User> users = userService.findAll();
        //when we call this function we need to find all (exm. users) from database and in next function we're sorting by id
        users.sort(Comparator.comparing(o -> o.getId()));
        model.addAttribute("users", users);

        model.addAttribute ("title", "Informations of all users");
        //With this function we can put title of the page

        return "userManagement";
    }
    @GetMapping("/")
    public String getLogIn(Model model) {

        model.addAttribute("title", "Welcome to user management");

        return "userLogin";
    }
}
