package com.example.projectx.service.customerService;

import com.example.projectx.appUtils.AppUtils;
import com.example.projectx.data.models.*;
import com.example.projectx.data.repositories.CustomerRepository;
import com.example.projectx.dto.request.JavaMailerRequest;
import com.example.projectx.dto.request.customer.CustomerLoginRequest;
import com.example.projectx.dto.request.customer.CustomerRegistrationRequest;
import com.example.projectx.dto.response.customer.CustomerLoginResponse;
import com.example.projectx.dto.response.customer.CustomerRegistrationResponse;
import com.example.projectx.exceptions.BadCredentialExceptions;
import com.example.projectx.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.projectx.appUtils.AppUtils.otpSubject;
import static com.example.projectx.exceptions.ExceptionMessages.EMAIL_ALREADY_EXIST;
import static com.example.projectx.exceptions.ExceptionMessages.INVALID_EMAIL;

@Service
@AllArgsConstructor
public class XCustomerService implements CustomerService{
    private final CustomerRepository customerRepository;
    private final TokenService tokenService;
    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest registrationRequest) {
        String email = registrationRequest.getEmail().toLowerCase().trim();
        String password = registrationRequest.getPassword();

        if (checkRegisterEmail(email)) throw new BadCredentialExceptions(EMAIL_ALREADY_EXIST.getMessage());

        Customer customer = customerMapper(email, password);

        String token = tokenService.createToken(email);

        JavaMailerRequest javaMailerRequest = new JavaMailerRequest();
        javaMailerRequest.setTo(email);
        javaMailerRequest.setMessage("Hello here is your token" + token);
        javaMailerRequest.setSubject(otpSubject);


        return null;
    }
    private Customer customerMapper(String email, String password){
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setRole(Roles.CUSTOMER);
        Cart cart = new Cart();
        customer.setCart(cart);
        return customer;

    }

    @Override
    public CustomerLoginResponse login(CustomerLoginRequest loginRequest) {
        return null;
    }
    private boolean checkRegisterEmail(String email) {
        if (!AppUtils.verifyEmail(email)) throw new BadCredentialsException(INVALID_EMAIL.getMessage());
        Optional<Customer> foundCustomer = customerRepository.findByEmail(email);
        return foundCustomer.isPresent();
    }
}
