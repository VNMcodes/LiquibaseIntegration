package com.vnmcodes.liquibase_integration.controller;

import com.vnmcodes.liquibase_integration.model.User;
import com.vnmcodes.liquibase_integration.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // POST new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}

