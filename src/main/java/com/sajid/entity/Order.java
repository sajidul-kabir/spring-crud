package com.sajid.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
public class Order {

    private int id;
    private String customer_name;
    private String address;
    private String product;
    private double transaction;

    public Order(String customer_name, String address, String product, double transaction) {
        this.customer_name = customer_name;
        this.address = address;
        this.product = product;
        this.transaction = transaction;
    }


}
