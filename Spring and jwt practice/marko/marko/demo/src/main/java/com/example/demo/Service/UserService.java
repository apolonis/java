package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//in this class we're creating function we needed from database
@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        List<User> users = repository.findAll();
        return users;
    }
    public boolean findUser(String userN, String password){
        boolean find= false;
        List<User> userList = repository.findAll();
        for(int i=0; i<userList.size();i++){
            if(userList.get(i).getUsername().equals(userN) && userList.get(i).getPassword().equals(password)){
                find = true;

            }
        }
        return find;
    }
    public boolean findUser(String userN){
        boolean find= false;
        List<User> userList = repository.findAll();
        for(int i=0; i<userList.size();i++){
            if(userList.get(i).getUsername().equals(userN)){
                find = true;

            }
        }
        return find;
    }
    public User findByUsername(String userN){
        User user = new User();
        List<User> userList = repository.findAll();
        for(int i=0; i<userList.size();i++){
            if(userList.get(i).getUsername().equals(userN)){
                user = userList.get(i);
            }
        }
        return user;
    }
    public User findByMail(String mail){
        User user = new User();
        List<User> userList = repository.findAll();
        for(int i=0; i<userList.size();i++){
            if(userList.get(i).getEmail().equals(mail)){
                user = userList.get(i);
            }
        }
        return user;
    }
    public void deleteUser(String username){
        User user = this.findByUsername(username);
        repository.delete(user);
    }
}