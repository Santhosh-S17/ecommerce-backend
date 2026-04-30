package com.santhosh.ecommercebackend.Repository;

import com.santhosh.ecommercebackend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByUserId(Long userId);
}
