package com.example.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exercise.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    
    Users findByUsername(String username);
}
