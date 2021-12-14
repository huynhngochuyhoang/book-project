package com.hoanghuynh.userservice.repository;

import com.hoanghuynh.userservice.model.User;
import com.hoanghuynh.userservice.model.UserInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByUserId(String uuid);

    @Query("SELECT NEW com.hoanghuynh.userservice.model.UserInfoDto(u.userId, u.email, u.phone, u.firstName, u.lastName)" +
            " FROM User u WHERE u.username = ?1")
    UserInfoDto getUserInfo(String username);
}
