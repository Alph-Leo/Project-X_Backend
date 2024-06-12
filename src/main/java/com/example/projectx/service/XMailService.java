package com.example.projectx.service;

import com.example.projectx.dto.request.JavaMailerRequest;

public class XMailService implements MailService{
    @Override
    public void send(JavaMailerRequest javaMailerRequest) {
        String mailReceiver = javaMailerRequest.getTo();
        String message = javaMailerRequest.getMessage();
        String subject = javaMailerRequest.getSubject();
        String sender = javaMailerRequest.getFrom();

    }
}
