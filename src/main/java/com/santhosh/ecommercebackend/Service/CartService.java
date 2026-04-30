package com.santhosh.ecommercebackend.Service;


import com.santhosh.ecommercebackend.Entity.Cart;
import com.santhosh.ecommercebackend.Entity.CartItem;
import com.santhosh.ecommercebackend.Entity.Product;
import com.santhosh.ecommercebackend.Repository.CartItemRepository;
import com.santhosh.ecommercebackend.Repository.CartRepository;
import com.santhosh.ecommercebackend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;


    public Cart addToCart(Long cartId, Long productId, int quantity){

        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);

        cartItemRepository.save(item);
        return cart;
    }

    public String removeFromCart(Long cartItemId){

    if(!cartItemRepository.existsById(cartItemId)){
        return "Item not found in cart";
        }

        cartItemRepository.deleteById(cartItemId);
        return "Item removed successfully";
    }

    public CartItem updateQuantity(Long cartItemId, int quantity){
        CartItem item = cartItemRepository.findById(cartItemId).orElse(null);

        if(item==null){
            return null;
        }

        item.setQuantity(quantity);
        return cartItemRepository.save(item);
    }
}
