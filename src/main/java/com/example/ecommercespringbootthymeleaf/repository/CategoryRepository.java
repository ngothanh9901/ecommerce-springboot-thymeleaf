package com.example.ecommercespringbootthymeleaf.repository;

import com.example.ecommercespringbootthymeleaf.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
