package com.example.projectx.exceptions;

public enum ExceptionMessages {

    INVALID_EMAIL("Invalid email provided"),
    INVALID_LOGIN_DETAILS("Invalid login details"),
    USER_NOT_FOUND("User not found"),
    PRODUCT_NOT_FOUND("Product not found"),
    INVALID_TOKEN_EMAIL("The provided email is not attached to the token"),
    PLEASE_FILL_ALL_FIELDS("Please provide all fields"),
    TOKEN_EXPIRED_PLEASE_GENERATE_ANOTHER_TOKEN_FOR_VERIFICATION("Token expired please request for another token for verification"),
    INVALID_AUTHORIZATION_HEADER_EXCEPTION("Invalid authorization header"),
    VERIFICATION_FAILED_EXCEPTION("Verification failed"),
    EMAIL_ALREADY_EXIST("Email already exist please login");

    private String message;
    ExceptionMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
