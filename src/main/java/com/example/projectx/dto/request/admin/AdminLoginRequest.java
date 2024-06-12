package com.example.projectx.dto.request.admin;

import com.example.projectx.data.models.Roles;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
public class AdminLoginRequest {
   private String email;
   private String password;
}
