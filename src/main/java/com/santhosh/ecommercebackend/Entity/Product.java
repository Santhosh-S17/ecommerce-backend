package com.santhosh.ecommercebackend.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private int stock;
}
