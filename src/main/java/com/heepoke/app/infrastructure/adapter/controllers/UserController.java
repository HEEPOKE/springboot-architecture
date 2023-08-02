package com.heepoke.app.infrastructure.adapter.controllers;

import org.springframework.web.bind.annotation.*;

import com.heepoke.app.application.service.UserService;
import com.heepoke.app.domain.models.User;
import com.heepoke.app.infrastructure.adapter.messaging.ResponseMessage;
import com.heepoke.app.infrastructure.adapter.messaging.StatusResponse;
import com.heepoke.app.shared.constants.Message;
import com.heepoke.app.shared.constants.Service;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseMessage<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        StatusResponse status = new StatusResponse( Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_CREATE, "");
        return new ResponseMessage<>(status, savedUser);
    }

    @PutMapping("/update/{userId}")
    public ResponseMessage<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User userUpdated = userService.updateUser(userId, updatedUser);
        StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_UPDATE, "");
        return new ResponseMessage<>(status, userUpdated);
    }

    @GetMapping("/get")
    public ResponseMessage<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_LIST, "");
        return new ResponseMessage<>(status, users);
    }

    @GetMapping("/find/{userId}")
    public ResponseMessage<Optional<User>> getUserById(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_BY_ID, "");
        return new ResponseMessage<>(status, user);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseMessage<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_DELETE, "");
        return new ResponseMessage<>(status, "User deleted successfully");
    }
}