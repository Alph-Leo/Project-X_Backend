package com.example.projectx.service;

import com.example.projectx.dto.request.JavaMailerRequest;

public interface MailService {
    void send(JavaMailerRequest javaMailerRequest);
}
