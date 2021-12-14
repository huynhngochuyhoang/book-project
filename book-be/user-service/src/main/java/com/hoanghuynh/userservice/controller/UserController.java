package com.hoanghuynh.userservice.controller;

import com.hoanghuynh.userservice.config.JwtConfig;
import com.hoanghuynh.userservice.model.MyUserDetails;
import com.hoanghuynh.userservice.model.User;
import com.hoanghuynh.userservice.model.UserInfoDto;
import com.hoanghuynh.userservice.model.UserRegisterDto;
import com.hoanghuynh.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtConfig jwtConfig;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRegisterDto user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> userLogin) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLogin.get("username"),
                        userLogin.get("password")
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtConfig.generateToken((MyUserDetails) authentication.getPrincipal());
        Map<String, String> response = new HashMap<>(2);
        response.put("tokenType", "Bearer");
        response.put("accessToken", jwt);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info")
    public ResponseEntity<UserInfoDto> userInfo(Authentication authentication) {
        return ResponseEntity.ok(userService.getUserInfo(authentication.getName()));
    }
}
