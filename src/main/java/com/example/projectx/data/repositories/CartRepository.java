package com.example.projectx.data.repositories;

import com.example.projectx.data.models.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
}
