package com.example.projectx.service.customerService;

import com.example.projectx.dto.request.customer.CustomerLoginRequest;
import com.example.projectx.dto.request.customer.CustomerRegistrationRequest;
import com.example.projectx.dto.response.customer.CustomerLoginResponse;
import com.example.projectx.dto.response.customer.CustomerRegistrationResponse;

public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest registrationRequest);
    CustomerLoginResponse login(CustomerLoginRequest loginRequest);
}
