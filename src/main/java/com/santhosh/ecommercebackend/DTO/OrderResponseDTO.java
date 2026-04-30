package com.santhosh.ecommercebackend.DTO;

import lombok.Data;

@Data
public class OrderResponseDTO {
    private Long orderId;
    private double totalPrice;
    private String status;
}
