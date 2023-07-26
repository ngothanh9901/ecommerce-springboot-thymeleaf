package com.example.ecommercespringbootthymeleaf.repository;

import com.example.ecommercespringbootthymeleaf.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
