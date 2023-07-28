package com.example.ecommercespringbootthymeleaf.controller;

import com.example.ecommercespringbootthymeleaf.model.Category;
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
@RequestMapping("/product")
public class ProductController {
  private final CategoryService categoryService;
  @GetMapping
  public String getProduct(){
//    return "product/addProduct";
    return "product/list";
  }
  @GetMapping("/register")
  public String register(Model model) {
    Category category = new Category();
    model.addAttribute("category", category);
    return "product/register";
  }
  @PostMapping("/register")
  public String onRegister(@ModelAttribute("category") Category category, Model model) {
    categoryService.save(category);
    return "role/role";
  }

}
