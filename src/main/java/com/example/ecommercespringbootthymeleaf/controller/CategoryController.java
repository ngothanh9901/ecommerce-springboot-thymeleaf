package com.example.ecommercespringbootthymeleaf.controller;

import com.example.ecommercespringbootthymeleaf.model.Category;
import com.example.ecommercespringbootthymeleaf.model.Role;
import com.example.ecommercespringbootthymeleaf.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {
  private final CategoryService categoryService;
  @GetMapping("/register")
  public String register(Model model) {
    Category category = new Category();
    model.addAttribute("category", category);
    return "category/register";
  }
  @PostMapping("/register")
  public String onRegister(@ModelAttribute("category") Category category, Model model) {
    categoryService.save(category);
    return "role/role";
  }
}
