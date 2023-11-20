package com.example.project.repository;

import com.example.project.repository.model.entity.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CartRepository extends MongoRepository<CartItem, String> {

    @Query("{Id:'?0'}")
    CartItem findItemById(String Id);

    public long count();
}
