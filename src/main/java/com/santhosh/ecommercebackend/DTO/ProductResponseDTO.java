package com.santhosh.ecommercebackend.DTO;

import lombok.Data;
import org.apache.logging.log4j.message.StringMapMessage;

@Data
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
}

