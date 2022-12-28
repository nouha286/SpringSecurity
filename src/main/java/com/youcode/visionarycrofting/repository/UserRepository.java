package com.youcode.visionarycrofting.repository;


import com.youcode.visionarycrofting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
}
