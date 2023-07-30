package com.example.ecommercespringbootthymeleaf.controller;

import com.example.ecommercespringbootthymeleaf.dto.payload.ProductPayload;
import com.example.ecommercespringbootthymeleaf.model.Category;
import com.example.ecommercespringbootthymeleaf.model.Product;
import com.example.ecommercespringbootthymeleaf.service.CategoryService;
import com.example.ecommercespringbootthymeleaf.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
  private final CategoryService categoryService;
  private final ProductService productService;
  @GetMapping
  public String getProduct(HttpServletRequest request, Model model){
    int currentPage = (request.getParameter("pageNumber") == null) ? 1 : Integer.parseInt(request.getParameter("pageNumber"));
    String name = (request.getParameter("name") == null) ? null : request.getParameter("name");
//    List<Integer> categoryIds = (request.getParameter("categoryIds") == null) ? null : request.getParameter("category");
    Page<Product> products = productService.findAll(name);
    List<Category> categories = categoryService.findAll();
    model.addAttribute("products",products.getContent());
    model.addAttribute("categories",categories);
    return "product/products";
  }
  @GetMapping("/register")
  public String register(Model model) {
    List<Category> categories = categoryService.findAll();
    ProductPayload productPayload = new ProductPayload();
    model.addAttribute("categories", categories);
    model.addAttribute("productPayload",productPayload);
    return "product/register";
  }
  @PostMapping("/register")
  public String onRegister(@ModelAttribute("productPayload") ProductPayload productPayload, Model model) {
    productService.add(productPayload);
    return "role/role";
  }
}
