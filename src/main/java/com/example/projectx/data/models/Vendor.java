package com.example.projectx.data.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Vendor")
@Setter
@Getter
@ToString
public class Vendor {
@Id
    private String vendorId;
    private String firstName;
    private String lastName;
    private String companyName;
    private String email;
    private String phoneNumber;
    private String password;
    private Product product;
    private Address address;
    private Roles role;
}
