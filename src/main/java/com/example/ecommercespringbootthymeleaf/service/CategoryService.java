package com.example.ecommercespringbootthymeleaf.service;

import com.example.ecommercespringbootthymeleaf.model.Category;

import java.util.List;

public interface CategoryService {
  Category save(Category category);
  List<Category> findAll();
}
