package com.example.projectx.dto.request.customer;

import com.example.projectx.data.models.Address;
import com.example.projectx.data.models.Cart;
import com.example.projectx.data.models.Roles;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class CustomerRegistrationRequest {
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private Address address;
    private Cart cart;
    private Roles role;
}
