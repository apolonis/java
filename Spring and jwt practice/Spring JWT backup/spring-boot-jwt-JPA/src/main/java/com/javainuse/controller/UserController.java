package com.javainuse.controller;

import com.javainuse.dao.UserDao;
import com.javainuse.model.DAOUser;
import com.javainuse.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserDao userDao;

    // Return All Users //
    @GetMapping
    public List<DAOUser> getAll() {
        return (List<DAOUser>) userDao.findAll();
    }

    // Return one user by uuid //
    @GetMapping("/uuid/{uuid}")
    public DAOUser show(@PathVariable String uuid) {
        DAOUser showUser = userDao.findByUuid(uuid);
        return showUser;
    }

    // Return all users by role //
    @GetMapping("/role/{role}")
    public List<DAOUser> showByRole(@PathVariable String role) {
        List<DAOUser> lista = userDao.findByRole(role);
        return lista;
    }

    // Return all users by name //
    @GetMapping("/name/{name}")
    public List<DAOUser> showByName(@PathVariable String name) {
        List<DAOUser> showUser = userDao.findByName(name);
        return showUser;
    }

    // Update User //
    @PutMapping("/{uuid}")
    public DAOUser updateUser(@PathVariable String uuid, @RequestBody UserDTO user){
        DAOUser updatedUser = userDao.findByUuid(uuid);
        updatedUser.setUsername(user.getUsername());
        updatedUser.setName(user.getName());
        updatedUser.setPassword(user.encode(user.getPassword()));
        System.out.println(updatedUser.getPassword());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setRole(user.getRole());
        userDao.save(updatedUser);
        return  updatedUser;
    }

    // Delete user by uuid //
    @Transactional
    @DeleteMapping("/uuid/{uuid}")
    public String deleteUser(@PathVariable String uuid){
        userDao.deleteByUuid(uuid);
        return "User with uniqe id: "+uuid+" has been deleted";
    }



}
