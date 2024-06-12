package com.example.projectx.data.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class User {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private Gender gender;
    private String email;
    private Roles role;
    private Address address;
}
