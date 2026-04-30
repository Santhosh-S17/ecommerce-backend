package com.santhosh.ecommercebackend.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@Table(name="cart")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
