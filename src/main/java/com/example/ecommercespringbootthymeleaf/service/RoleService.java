package com.example.ecommercespringbootthymeleaf.service;

import com.example.ecommercespringbootthymeleaf.model.Role;

import java.util.List;

public interface RoleService {
  Role save(Role role);
  List<Role> findAll();
}
