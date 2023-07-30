package com.example.ecommercespringbootthymeleaf.controller;

import com.example.ecommercespringbootthymeleaf.annotation.CurrentUser;
import com.example.ecommercespringbootthymeleaf.model.Product;
import com.example.ecommercespringbootthymeleaf.security.UserPrincipal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequestMapping("/product")
public class OrderController {
    public String getCart(@CurrentUser UserPrincipal userPrincipal){
        return "order/cart";
    }
    @PostMapping
    public String addProductToCart(){

        return "order/cart";
    }
}
