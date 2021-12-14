package com.hoanghuynh.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    private String userId;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
}
