package com.example.project.repository;

import com.example.project.repository.model.entity.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ShoppingCartRepository  extends MongoRepository<ShoppingCart, String> {
    @Query("{id:'?0'}")
    ShoppingCart findItemById(String id);

    public long count();
}
