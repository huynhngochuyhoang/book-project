package com.hoanghuynh.userservice.service.impl;

import com.hoanghuynh.userservice.model.User;
import com.hoanghuynh.userservice.model.UserDto;
import com.hoanghuynh.userservice.repository.UserRepository;
import com.hoanghuynh.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserDto user) {
        return userRepository.save(User.builder()
                .username(user.getUsername())
                .userId(UUID.randomUUID().toString())
                .phone(user.getPhone())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(passwordEncoder.encode(user.getPassword()))
                .role("ROLE_USER")
                .build());
    }
}
