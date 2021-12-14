package com.hoanghuynh.userservice.service;

import com.hoanghuynh.userservice.model.User;
import com.hoanghuynh.userservice.model.UserInfoDto;
import com.hoanghuynh.userservice.model.UserRegisterDto;

public interface UserService {
    User createUser(UserRegisterDto user);
    UserInfoDto getUserInfo(String username);
}
