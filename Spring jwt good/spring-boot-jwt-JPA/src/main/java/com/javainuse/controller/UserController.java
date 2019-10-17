package com.javainuse.controller;

import com.javainuse.model.User;
import com.javainuse.model.UserDTO;
import com.javainuse.repository.UserDao;
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
    public List<User> getAll() {
        return (List<User>) userDao.findAll();
    }

    // Return one user by uuid //
    @GetMapping("/{uuid}")
    public User show(@PathVariable String uuid) {
        User showUser = userDao.findByUuid(uuid);
        return showUser;
    }

    // Return all users by role //
    @GetMapping("/role/{role}")
    public List<User> showByRole(@PathVariable String role) {
        List<User> lista = userDao.findByRole(role);
        return lista;
    }

    // Return all users by name //
    @GetMapping("/name/{name}")
    public List<User> showByName(@PathVariable String name) {
        List<User> names = userDao.findByName(name);
        return names;
    }

    // Update User //
    @PutMapping("/updateByUuid/{uuid}")
    public User updateUser(@PathVariable String uuid, @RequestBody UserDTO user) {
        User updatedUser = userDao.findByUuid(uuid);
        updatedUser.setUsername(user.getUsername());
        updatedUser.setName(user.getName());
        updatedUser.setPassword(user.encode(user.getPassword()));
        updatedUser.setLastname(user.getLastname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setRole(user.getRole());
        userDao.save(updatedUser);
        return updatedUser;
    }

    // Delete user by uuid //
    @Transactional
    @DeleteMapping("/{uuid}")
    public String deleteUser(@PathVariable String uuid) {
        userDao.deleteByUuid(uuid);
        return "Deleted";
    }

    @PutMapping("/updateById/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody UserDTO user) {
        User updatedUser = userDao.findById(id);
        updatedUser.setUsername(user.getUsername());
        updatedUser.setName(user.getName());
        updatedUser.setPassword(user.encode(user.getPassword()));
        updatedUser.setLastname(user.getLastname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setRole(user.getRole());
        userDao.save(updatedUser);
        return updatedUser;
    }

}
