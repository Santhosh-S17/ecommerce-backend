package com.santhosh.ecommercebackend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestResponseDTO {
    private Long orderID;
    private double totalPrice;
    private String status;

    private List<OrderItemRequestResponseDTO> items;
}
