package com.santhosh.ecommercebackend.DTO;

import lombok.Data;

@Data
public class CartItemResponseDTO {
    private Long productId;
    private String productName;
    private int quantity;
    private double price;
}
