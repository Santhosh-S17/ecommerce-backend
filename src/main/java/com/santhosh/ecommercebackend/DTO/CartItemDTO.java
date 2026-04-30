package com.santhosh.ecommercebackend.DTO;

import lombok.Data;

@Data
public class CartItemDTO {
    private Long productId;
    private int quantity;
}
