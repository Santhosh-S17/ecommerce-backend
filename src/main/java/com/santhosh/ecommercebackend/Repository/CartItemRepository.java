package com.santhosh.ecommercebackend.Repository;

import com.santhosh.ecommercebackend.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
