package com.example.projectx.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse <T>{
    private T data;
}
