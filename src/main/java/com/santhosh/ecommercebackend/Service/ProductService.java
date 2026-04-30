package com.santhosh.ecommercebackend.Service;


import com.santhosh.ecommercebackend.DTO.ProductDTO;
import com.santhosh.ecommercebackend.DTO.ProductResponseDTO;
import com.santhosh.ecommercebackend.Entity.Product;
import com.santhosh.ecommercebackend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO addProduct(ProductDTO dto) {

        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        Product saved = productRepository.save(product);

        ProductResponseDTO res = new ProductResponseDTO();
        res.setId(saved.getId());
        res.setName(saved.getName());
        res.setDescription(saved.getDescription());
        res.setPrice(saved.getPrice());

        return res;
    }

    public List<Product> getAllproducts(){
        return productRepository.findAll();
    }

    public Product getById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
