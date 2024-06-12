package com.example.projectx;

import com.example.projectx.data.models.Roles;
import com.example.projectx.dto.request.admin.AdminLoginRequest;
import com.example.projectx.dto.request.admin.AdminRegistrationRequest;
import com.example.projectx.dto.response.admin.AdminLoginResponse;
import com.example.projectx.dto.response.admin.AdminRegistrationResponse;
import com.example.projectx.service.adminService.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Test
    @Order(1)
    public void testThatAdminCanRegister(){
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("saidex1@ymail.com");
        request.setPassword("ajokeade");
        request.setRole(Roles.ADMIN);

        AdminRegistrationResponse response = adminService.register(request);
        assertThat(response).isNotNull();
    }
    @Test
    @Order(2)
    public void testThatAdmin2CanRegister(){
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("akinladeo65@gmail.com");
        request.setPassword("lovelyboy100");
        request.setRole(Roles.ADMIN);


        AdminRegistrationResponse response = adminService.register(request);
        assertThat(response).isNotNull();
    }

    @Test
    @Order(3)
    public void testThatAdminCanLogin(){
        AdminLoginRequest loginRequest = new AdminLoginRequest();
        loginRequest.setEmail("Akinladeo65@gmail.com");
        loginRequest.setPassword("lovelyboy100");

        AdminLoginResponse response = adminService.login(loginRequest);
        assertThat(response).isNotNull();
        log.info("Welcome Back!",response);
    }
}
