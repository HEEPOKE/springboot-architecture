package com.heepoke.app.infrastructure.adapter.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.heepoke.app.application.service.UserService;
import com.heepoke.app.domain.models.User;
import com.heepoke.app.infrastructure.adapter.messaging.ResponseMessage;
import com.heepoke.app.infrastructure.adapter.messaging.StatusResponse;
import com.heepoke.app.shared.constants.Description;
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
    public ResponseEntity<ResponseMessage<User>> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        StatusResponse status = new StatusResponse( Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_CREATE, Description.USER_CREATE_SUCCESS);
        ResponseMessage<User> responseBody = new ResponseMessage<>(status, savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PutMapping("/update/{userId}")
    public ResponseMessage<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User userUpdated = userService.updateUser(userId, updatedUser);
        StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_UPDATE, Description.USER_UPDATE_SUCCESS);
        return new ResponseMessage<>(status, userUpdated);
    }

    @GetMapping("/get")
    public ResponseMessage<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_LIST, Description.USER_LIST_SUCCESS);
        return new ResponseMessage<>(status, users);
    }

    @GetMapping("/find/{userId}")
    public ResponseMessage<Optional<User>> getUserById(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_BY_ID, Description.USER_BY_ID_SUCCESS);
        return new ResponseMessage<>(status, user);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseMessage<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_DELETE, Description.USER_DELETE_SUCCESS);
        return new ResponseMessage<>(status, "User deleted successfully");
    }
}