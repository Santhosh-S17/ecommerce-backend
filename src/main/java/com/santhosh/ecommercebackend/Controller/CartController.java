package com.santhosh.ecommercebackend.Controller;


import com.santhosh.ecommercebackend.Entity.Cart;
import com.santhosh.ecommercebackend.Entity.CartItem;
import com.santhosh.ecommercebackend.Entity.User;
import com.santhosh.ecommercebackend.Repository.CartRepository;
import com.santhosh.ecommercebackend.Repository.UserRepository;
import com.santhosh.ecommercebackend.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/create")
    public Cart createCart(@RequestParam Long userId){
        User user = userRepository.findById(userId).orElseThrow();

        Cart cart = new Cart();
        cart.setUser(user);

        return cartRepository.save(cart);
    }

    //add to cart
    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long cartId,
                          @RequestParam Long productId,
                          @RequestParam int quantity){
        return cartService.addToCart(cartId,productId,quantity);
    }

    //remove from cart
    @DeleteMapping("/remove/{cartItemId}")
    public String remove(@PathVariable Long cartItemId){
        return cartService.removeFromCart(cartItemId);
    }

    //Update
    @PutMapping("/update")
    public CartItem update(@RequestParam Long cartItemId,
                           @RequestParam int quantity){
        return cartService.updateQuantity(cartItemId,quantity);
    }

}
