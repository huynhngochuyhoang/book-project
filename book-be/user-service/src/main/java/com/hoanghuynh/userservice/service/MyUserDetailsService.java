package com.hoanghuynh.userservice.service;

import com.hoanghuynh.userservice.model.MyUserDetails;
import com.hoanghuynh.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserDetails(userRepository.findUserByUsername(username).orElseThrow());
    }

    public UserDetails loadUserByUserId(String userId) {
        return new MyUserDetails(userRepository.findUserByUserId(userId).orElseThrow());
    }
}
