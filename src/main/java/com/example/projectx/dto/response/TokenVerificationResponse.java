package com.example.projectx.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenVerificationResponse {
    private String token;
    private String userAccessToken;
}
