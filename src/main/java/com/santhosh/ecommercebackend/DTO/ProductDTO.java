package com.santhosh.ecommercebackend.DTO;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private  String description;
    private Double price;
    private int stock;
}
