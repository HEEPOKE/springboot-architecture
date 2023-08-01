package com.heepoke.app.infrastructure.adapter.controllers;

import org.springframework.web.bind.annotation.*;

import com.heepoke.app.application.service.UserService;
import com.heepoke.app.domain.models.User;

import java.util.List;

@RestController
@RequestMapping("/apis/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}