package com.example.projectx.appUtils;

public class AppUtils {

    public static final String APP_NAME = "Project-X";
    public static final String APP_MAIL_SENDER = "saidex1@ymail.com";
    public static final String PRODUCT_ADD_MESSAGE = "Product added successfully";
    public static final String otpSubject = "PROJECT-X_VERIFICATION_OTP";
    public static final String BEARER = "Bearer";
    public static final String USER_ID = "userId";
    public static final String SECRET_KEY = "project-x_secretKey";
    public static final String BLANK_SPACE = " ";
    public static boolean verifyEmail(String email){
        return  email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
}
