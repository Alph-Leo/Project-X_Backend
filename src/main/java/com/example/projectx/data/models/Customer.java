package com.example.projectx.data.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("Customer")
@Setter
@Getter
@ToString
public class Customer extends User{
    @Id
    private String customerId;
    private Cart cart;
    private List<Order> orders = new ArrayList();
    private List<Product> wishList = new ArrayList<>();
    private List<Address> addressList = new ArrayList<>();
    private boolean isActive;
    private Notification notification;


}
