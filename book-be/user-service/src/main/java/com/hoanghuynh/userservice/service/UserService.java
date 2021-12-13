package com.hoanghuynh.userservice.service;

import com.hoanghuynh.userservice.model.User;
import com.hoanghuynh.userservice.model.UserDto;

public interface UserService {
    User createUser(UserDto user);
}
