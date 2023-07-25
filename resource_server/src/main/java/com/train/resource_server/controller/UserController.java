package com.train.resource_server.controller;

import com.train.resource_server.entity.Users;
import com.train.resource_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Users getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
}
