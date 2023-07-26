package com.example.ecommercespringbootthymeleaf.controller;

import com.example.ecommercespringbootthymeleaf.model.Role;
import com.example.ecommercespringbootthymeleaf.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/role")
public class RoleController {
  private final RoleService roleService;
  @GetMapping("/register")
  public String register(Model model) {
    Role role = new Role();
    model.addAttribute("role", role);
    return "role/register";
  }
  @PostMapping("/register")
  public String onRegister(@ModelAttribute("role") Role role, Model model) {
    roleService.save(role);
    model.addAttribute("roles",roleService.findAll());
    return "role/role";
  }
}
