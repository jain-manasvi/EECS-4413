package com.example.project.repository;

import com.example.project.repository.model.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AddressRepository extends MongoRepository<Address, String> {

    @Query("{street:'?0'}")
    Address findItemByStreet(String street);

    public long count();
}
