package com.example.upvote.repository;

import com.example.upvote.domain.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {

    CustomUser findCustomUserByUsername(String s);
}
