package com.example.projectx.data.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("Admin")
@Setter
@Getter
@ToString
public class Admin extends User{
    @Id
    private String adminId;
    private List<Vendor> toVerify = new ArrayList<>();
    private Notification notification;
}
