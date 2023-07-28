package com.example.ecommercespringbootthymeleaf.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
  @GetMapping
  public String getProduct(){
//    return "product/addProduct";
    return "product/list";
  }

}
