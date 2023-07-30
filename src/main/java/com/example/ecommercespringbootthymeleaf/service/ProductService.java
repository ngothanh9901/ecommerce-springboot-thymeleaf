package com.example.ecommercespringbootthymeleaf.service;

import com.example.ecommercespringbootthymeleaf.dto.payload.ProductPayload;
import com.example.ecommercespringbootthymeleaf.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product add(ProductPayload payload);
    Page<Product> findAll(String name);
}
