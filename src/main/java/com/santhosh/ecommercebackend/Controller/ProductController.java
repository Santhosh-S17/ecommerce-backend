package com.santhosh.ecommercebackend.Controller;


import com.santhosh.ecommercebackend.DTO.ProductDTO;
import com.santhosh.ecommercebackend.DTO.ProductResponseDTO;
import com.santhosh.ecommercebackend.Entity.Product;
import com.santhosh.ecommercebackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //add product
    @PostMapping
    public ProductResponseDTO addProduct(@RequestBody ProductDTO dto) {
        return productService.addProduct(dto);
    }

    //get all product
    @GetMapping
    public List<Product> getAll(){
        return productService.getAllproducts();
    }

    //Get by Id
    @GetMapping("/{id}")
    public Product getById(@PathVariable  Long id){
        return productService.getById(id);
    }

    //Delet by Id
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
}


