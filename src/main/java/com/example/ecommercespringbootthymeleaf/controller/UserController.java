package com.example.ecommercespringbootthymeleaf.controller;

import com.example.ecommercespringbootthymeleaf.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
  @GetMapping("/register")
  public String register(Model model) {
    Users user = new Users();
    model.addAttribute("user", user);
    return "user/register";
  }
  @PostMapping("/register")
  public String onRegister(@ModelAttribute("user") Users user, Model model) {
    System.out.println(user);
    return "role/role";
  }
}
