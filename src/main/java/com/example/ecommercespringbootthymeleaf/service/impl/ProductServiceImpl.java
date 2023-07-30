package com.example.ecommercespringbootthymeleaf.service.impl;

import com.example.ecommercespringbootthymeleaf.dto.payload.ProductPayload;
import com.example.ecommercespringbootthymeleaf.model.Category;
import com.example.ecommercespringbootthymeleaf.model.Product;
import com.example.ecommercespringbootthymeleaf.repository.CategoryRepository;
import com.example.ecommercespringbootthymeleaf.repository.ProductRepository;
import com.example.ecommercespringbootthymeleaf.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    @Override
    public Product add(ProductPayload payload) {
        List<Category> categories = categoryRepository.findAllById(payload.getCategoryIds());
        Product product = payload.convertToModel();
        product.setCategories(categories);
        product = productRepository.save(product);
        return product;
    }

    @Override
    public Page<Product> findAll(String name) {
        Pageable pageable = PageRequest.of(0 , 12);
        return productRepository.search(name,pageable);
    }
}
