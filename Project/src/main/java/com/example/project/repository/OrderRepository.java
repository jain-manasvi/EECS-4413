package com.example.project.repository;

import com.example.project.repository.model.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrderRepository extends MongoRepository<Order, String> {
    @Query("{id:'?0'}")
    Order findItemById(String id);

    public long count();
}
