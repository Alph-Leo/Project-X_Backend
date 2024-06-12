package com.example.projectx.dto.request;

import com.example.projectx.appUtils.AppUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JavaMailerRequest {
    private String to;
    private String subject;
    private String message;
    private String from = AppUtils.APP_MAIL_SENDER;
}
