package com.sajid.dto;


import lombok.Data;
@Data
public class OrderDto {
    private int id;
    private String customer_name;
    private String product;
    private Double transaction;
    private String address;

}
