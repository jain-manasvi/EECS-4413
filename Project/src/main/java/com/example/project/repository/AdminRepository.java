package com.example.project.repository;

import com.example.project.repository.model.entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AdminRepository extends MongoRepository<Admin, String> {

    @Query("{Id:'?0'}")
    Admin findItemByStreet(String Id);

    public long count();
}
