package com.example.projectx.service;

import com.example.projectx.data.models.Token;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

public interface TokenService {
    String createToken(String email);
    Token findOwnerByEmail(String email);
    void deleteToken(String id);
}
