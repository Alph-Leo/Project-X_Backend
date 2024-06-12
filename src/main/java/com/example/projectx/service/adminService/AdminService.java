package com.example.projectx.service.adminService;

import com.example.projectx.data.models.Admin;
import com.example.projectx.dto.request.admin.AdminLoginRequest;
import com.example.projectx.dto.request.admin.AdminRegistrationRequest;
import com.example.projectx.dto.response.admin.AdminLoginResponse;
import com.example.projectx.dto.response.admin.AdminRegistrationResponse;

public interface AdminService {

    AdminRegistrationResponse register(AdminRegistrationRequest request);
    AdminLoginResponse login(AdminLoginRequest loginRequest);
    Admin findAdminByEmail(String email);
}
