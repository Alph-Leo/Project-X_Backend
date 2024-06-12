package com.example.projectx.data.repositories;

import com.example.projectx.data.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
