package com.example.projectx.data.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Document("Token")
public class Token {
    private String id;
    private String token;
    private String ownerEmail;
    private LocalDateTime timeCreated = LocalDateTime.now();

}
