package com.example.projectx.data.repositories;

import com.example.projectx.data.models.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorRepository extends MongoRepository<Vendor, String> {
}
