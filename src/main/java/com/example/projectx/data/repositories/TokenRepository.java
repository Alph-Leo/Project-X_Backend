package com.example.projectx.data.repositories;

import com.example.projectx.data.models.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token, String> {
    Optional<Token> findOwnerByEmail(String email);
}
