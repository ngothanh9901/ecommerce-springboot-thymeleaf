package com.example.ecommercespringbootthymeleaf.repository;

import com.example.ecommercespringbootthymeleaf.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE :name IS NULL OR p.name = :name")
    Page<Product> search(@Param("name") String name, Pageable pageable);
}
