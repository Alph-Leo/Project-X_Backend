package com.example.projectx.dto.request.admin;

import com.example.projectx.data.models.Roles;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class AdminRegistrationRequest {
    @Id
    private String adminId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Roles role;
}
