package com.example.projectx.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document("Orders")
public class Order {
    @Id
    private String id;
    private List<Product> orderedProduct;
    private BigDecimal orderAmount;
    private Address deliveryAddress;
    private String deliveryDate = deliveryTimeline();
    private OrderStatus status;
    private String createdAt = setCreatedAt();
    private String customerId;



    private static String setCreatedAt(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        return localDateTime.format(formatter);
    }

    private static String deliveryTimeline(){
        LocalDate localDate = LocalDate.now().plusDays(7);
        String deliveryDate = String.valueOf(localDate);
        return deliveryDate;
    }
}
