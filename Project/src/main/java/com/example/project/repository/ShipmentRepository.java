package com.example.project.repository;

import com.example.project.repository.model.entity.Shipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ShipmentRepository extends MongoRepository<Shipment, String> {
    @Query("{id:'?0'}")
    Shipment findItemById(String id);

    public long count();
}

