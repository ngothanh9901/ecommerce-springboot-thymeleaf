package com.example.ecommercespringbootthymeleaf.controller;

import com.example.ecommercespringbootthymeleaf.model.Users;
import com.example.ecommercespringbootthymeleaf.service.UserService;
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
@RequestMapping("/user")
public class UserController {
  private final UserService userService;
  @GetMapping("/register")
  public String register(Model model) {
    Users user = new Users();
    model.addAttribute("user", user);
    return "user/register";
  }
  @PostMapping("/register")
  public String onRegister(@ModelAttribute("user") Users user, Model model) {
    userService.register(user);
    return "role/role";
  }
}
