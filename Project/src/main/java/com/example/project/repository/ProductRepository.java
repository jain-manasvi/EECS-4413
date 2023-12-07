package com.example.project.repository;

import com.example.project.repository.model.entity.Product;
import com.example.project.repository.model.entity.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{id:'?0'}")
    Product findItemById(String id);

    public long count();
    @Query(value="{brand:'?0'}", fields="{'name' : 1, 'description' : 1, 'price': 1, 'model': 1}")
    List<Product> findAll(String brand);


}