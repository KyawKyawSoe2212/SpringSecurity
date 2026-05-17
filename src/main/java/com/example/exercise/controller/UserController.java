package com.example.exercise.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.exercise.entity.Users;
import com.example.exercise.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/getUsers")
    public List<Users> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user){
        return userService.registerUser(user);
    }
    
    @PostMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/getUser/{id}")
    public Users getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/getUserByName/{username}")
    public Users getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody Users user) {
        return userService.verifyUser(user);
    }
    
}

