package com.heepoke.app.application.service;

import org.springframework.stereotype.Service;

import com.heepoke.app.domain.models.User;
import com.heepoke.app.domain.repositories.UserRepository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User saveUser(User user) {
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long userId, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setTel(updatedUser.getTel());
            user.setRole(updatedUser.getRole());
            user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return userRepository.save(user);
        }

        return null;
    }

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}