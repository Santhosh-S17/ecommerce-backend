package com.santhosh.ecommercebackend.Repository;

import com.santhosh.ecommercebackend.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
