package com.example.projectx.service.adminService;

import com.example.projectx.appUtils.AppUtils;
import com.example.projectx.data.models.Admin;
import com.example.projectx.data.models.Roles;
import com.example.projectx.data.repositories.AdminRepository;
import com.example.projectx.dto.request.admin.AdminLoginRequest;
import com.example.projectx.dto.request.admin.AdminRegistrationRequest;
import com.example.projectx.dto.response.admin.AdminLoginResponse;
import com.example.projectx.dto.response.admin.AdminRegistrationResponse;
import com.example.projectx.exceptions.BadCredentialExceptions;
import com.example.projectx.exceptions.ProjectXException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.projectx.dto.response.ResponseMessages.REGISTRATION_SUCCESSFUL;
import static com.example.projectx.dto.response.ResponseMessages.WELCOME_BACK;
import static com.example.projectx.exceptions.ExceptionMessages.*;

@Service
@AllArgsConstructor
public class AdminServiceImplementation implements AdminService{

    private final AdminRepository adminRepository;
    @Override
    public AdminRegistrationResponse register(AdminRegistrationRequest request) {
        String email = request.getEmail().toLowerCase().trim();
        String password = request.getPassword();

        if (checkRegisterEmail(email)) throw new BadCredentialExceptions(EMAIL_ALREADY_EXIST.getMessage());

        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setRole(Roles.ADMIN);

        adminRepository.save(admin);

        AdminRegistrationResponse response = new AdminRegistrationResponse();
        response.setMessage(REGISTRATION_SUCCESSFUL.name());
        return response;

    }

    @Override
    public AdminLoginResponse login(AdminLoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Admin foundAdmin = adminRepository.findByEmail(email)
                                        .orElseThrow(()-> new BadCredentialExceptions(INVALID_LOGIN_DETAILS.getMessage()));
        if (foundAdmin.getPassword().equals(password)){
            AdminLoginResponse response = new AdminLoginResponse();
            response.setMessage(WELCOME_BACK.name());
            return response;
        }
        throw new BadCredentialExceptions(INVALID_LOGIN_DETAILS.getMessage());
    }

    @Override
    public Admin findAdminByEmail(String email) {
        Admin foundAdmin = adminRepository.findByEmail(email)
                .orElseThrow(()->new BadCredentialExceptions(USER_NOT_FOUND.getMessage()));
        return foundAdmin;
    }


    private boolean checkRegisterEmail(String email){
        if (!AppUtils.verifyEmail(email)) throw new BadCredentialsException(INVALID_EMAIL.getMessage());
        Optional<Admin> foundAdmin = adminRepository.findByEmail(email);
        return foundAdmin.isPresent();
    }
}
