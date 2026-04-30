package com.santhosh.ecommercebackend.DTO;

import lombok.Data;

@Data
public class OrderItemRequestDTO {
    private Long productId;
    private int quantity;
}
