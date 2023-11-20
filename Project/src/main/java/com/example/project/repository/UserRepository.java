package com.example.project.repository;

import com.example.project.repository.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository <User, String> {
    @Query("{id:'?0'}")
    User findItemById(String id);

    public long count();

    @Query("{email:'?0'}")
    User findByEmail(String email);
}
