package com.hoanghuynh.userservice.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @Email(message = "Email invalid")
    private String email;

    @Min(value = 10)
    private String phone;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
}
