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
@Api(tags = "User")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Create a new user")
    @PostMapping("/create")
    public ResponseEntity<ResponseMessage<User>> createUser(@RequestBody User user) {
        try {
            User savedUser = userService.saveUser(user);
            StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_CREATE, Description.USER_CREATE_SUCCESS);
            ResponseMessage<User> responseBody = new ResponseMessage<>(status, savedUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
        } catch (Exception ex) {
            StatusResponse status = new StatusResponse(Message.FAILED.getCode(), Message.FAILED.getMessage(), Service.USER_CREATE, Description.USER_CREATE_FAILED);
            ResponseMessage<User> responseBody = new ResponseMessage<>(status, ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }
    }

    @ApiOperation(value = "Update user")
    @PutMapping("/update/{userId}")
    public ResponseEntity<ResponseMessage<User>> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        try {
            User userUpdated = userService.updateUser(userId, updatedUser);
            StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_UPDATE, Description.USER_UPDATE_SUCCESS);
            ResponseMessage<User> responseBody = new ResponseMessage<>(status, userUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        } catch (Exception ex) {
            StatusResponse status = new StatusResponse(Message.FAILED.getCode(), Message.FAILED.getMessage(), Service.USER_UPDATE, Description.USER_UPDATE_FAILED);
            ResponseMessage<User> responseBody = new ResponseMessage<>(status, ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }
    }

    @ApiOperation(value = "Get all users")
    @GetMapping("/get")
    public ResponseEntity<ResponseMessage<List<User>>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_LIST, Description.USER_LIST_SUCCESS);
            ResponseMessage<List<User>> responseBody = new ResponseMessage<>(status, users);
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        } catch (Exception ex) {
            StatusResponse status = new StatusResponse(Message.FAILED.getCode(), Message.FAILED.getMessage(), Service.USER_LIST, Description.USER_LIST_FAILED);
            ResponseMessage<List<User>> responseBody = new ResponseMessage<>(status, ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }
    }

    @ApiOperation(value = "Find user By ID")
    @GetMapping("/find/{userId}")
    public ResponseEntity<ResponseMessage<Optional<User>>> getUserById(@PathVariable Long userId) {
        try {
            Optional<User> user = userService.getUserById(userId);
            StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_BY_ID, Description.USER_BY_ID_SUCCESS);
            ResponseMessage<Optional<User>> responseBody = new ResponseMessage<>(status, user);
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        } catch (Exception ex) {
            StatusResponse status = new StatusResponse(Message.FAILED.getCode(), Message.FAILED.getMessage(), Service.USER_BY_ID, Description.USER_BY_ID_FAILED);
            ResponseMessage<Optional<User>> responseBody = new ResponseMessage<>(status, ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }
    }

    @ApiOperation(value = "Delete user")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseMessage<Boolean>> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            StatusResponse status = new StatusResponse(Message.SUCCESS.getCode(), Message.SUCCESS.getMessage(), Service.USER_DELETE, Description.USER_DELETE_SUCCESS);
            ResponseMessage<Boolean> responseBody = new ResponseMessage<>(status, true);
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        } catch (Exception ex) {
            StatusResponse status = new StatusResponse(Message.FAILED.getCode(), Message.FAILED.getMessage(), Service.USER_DELETE, Description.USER_DELETE_FAILED);
            ResponseMessage<Boolean> responseBody = new ResponseMessage<>(status, ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }
    }
}