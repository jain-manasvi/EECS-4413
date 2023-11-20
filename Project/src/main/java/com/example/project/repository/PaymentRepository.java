package com.example.project.repository;

import com.example.project.repository.model.entity.Order;
import com.example.project.repository.model.entity.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PaymentRepository extends MongoRepository<Payment, String> {
    @Query("{id:'?0'}")
    Payment findItemById(String id);

    public long count();

}
