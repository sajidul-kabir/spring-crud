package com.sajid.entity;


import lombok.*;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
