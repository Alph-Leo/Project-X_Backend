package com.example.projectx.exceptions;

import com.example.projectx.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class AppGlobalExceptionHandler {
    @ExceptionHandler(value = {ProjectXException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ResponseEntity<?> handler(ProjectXException projectXException){
        var response = ApiResponse.builder().data(projectXException.getMessage()).build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = {TokenExpiredException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ResponseEntity<?> handler(TokenExpiredException tokenExpiredException){
        var response = ApiResponse.builder().data(tokenExpiredException.getMessage()).build();
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(value = {IOException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ResponseEntity<?> handler(IOException exception){
        var response = ApiResponse.builder().data(exception.getMessage()).build();
        return ResponseEntity.badRequest().body(response);
    }

}
