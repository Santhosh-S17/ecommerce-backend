package com.santhosh.ecommercebackend.Service;


import com.santhosh.ecommercebackend.DTO.OrderItemRequestDTO;
import com.santhosh.ecommercebackend.DTO.OrderRequestDTO;
import com.santhosh.ecommercebackend.DTO.OrderRequestResponseDTO;
import com.santhosh.ecommercebackend.DTO.OrderResponseDTO;
import com.santhosh.ecommercebackend.Entity.Order;
import com.santhosh.ecommercebackend.Entity.OrderItem;
import com.santhosh.ecommercebackend.Entity.Product;
import com.santhosh.ecommercebackend.Entity.User;
import com.santhosh.ecommercebackend.Repository.OrderRepository;
import com.santhosh.ecommercebackend.Repository.ProductRepository;
import com.santhosh.ecommercebackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public OrderResponseDTO placeOrder(OrderRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create Order Entity
        Order order = new Order();
        order.setStatus("PLACED");

        double totalPrice = 0;

        List<OrderItem> orderItems = new ArrayList<>();

        // Loop through items
        for (OrderItemRequestDTO itemDTO : dto.getItems()) {

            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(itemDTO.getQuantity());
            item.setPrice(product.getPrice());

            item.setOrder(order);

            totalPrice += product.getPrice() * itemDTO.getQuantity();

            orderItems.add(item);
        }

        //  Set values
        order.setOrderItems(orderItems);
        order.setTotal_price(totalPrice);
        order.setUser(user);

        // Save
        Order savedOrder = orderRepository.save(order);

        // Convert to Response DTO
        OrderResponseDTO response = new OrderResponseDTO();
        response.setOrderId(savedOrder.getId());
        response.setTotalPrice(savedOrder.getTotal_price());
        response.setStatus(savedOrder.getStatus());

        return response;
    }

    public List<OrderResponseDTO> getOrderByUser(Long userId) {

        List<Order> orders = orderRepository.findByUserId(userId);

        List<OrderResponseDTO> responseList = new ArrayList<>();

        for (Order order : orders) {

            OrderResponseDTO dto = new OrderResponseDTO();
            dto.setOrderId(order.getId());
            dto.setTotalPrice(order.getTotal_price());
            dto.setStatus(order.getStatus());

            responseList.add(dto);
        }

        return responseList;
    }
}
