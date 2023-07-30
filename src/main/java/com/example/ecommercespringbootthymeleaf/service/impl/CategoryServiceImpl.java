package com.example.ecommercespringbootthymeleaf.service.impl;

import com.example.ecommercespringbootthymeleaf.model.Category;
import com.example.ecommercespringbootthymeleaf.repository.CategoryRepository;
import com.example.ecommercespringbootthymeleaf.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;
  @Override
  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

}
