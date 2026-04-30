package com.santhosh.ecommercebackend.Controller;

import com.santhosh.ecommercebackend.DTO.OrderRequestDTO;
import com.santhosh.ecommercebackend.DTO.OrderResponseDTO;
import com.santhosh.ecommercebackend.Entity.Order;
import com.santhosh.ecommercebackend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //place order
    @PostMapping
    public OrderResponseDTO placeOrder(@RequestBody OrderRequestDTO dto){

        return orderService.placeOrder(dto);
    }

    //get order by user
    @GetMapping("/user/{userId}")
    public List<OrderResponseDTO> getOrders(@PathVariable Long userId){
        return orderService.getOrderByUser(userId);
    }
}
