package com.example.project.repository;

import com.example.project.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository <User, String> {
    List<User> findUserByEmail(String email);
}
