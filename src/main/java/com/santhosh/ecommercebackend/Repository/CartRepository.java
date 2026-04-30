package com.santhosh.ecommercebackend.Repository;

import com.santhosh.ecommercebackend.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
