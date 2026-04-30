package com.santhosh.ecommercebackend.Repository;

import com.santhosh.ecommercebackend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
