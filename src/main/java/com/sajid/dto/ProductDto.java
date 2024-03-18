package com.sajid.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class ProductDto {
    private int id;
    private String name;
    private Double price;
}
