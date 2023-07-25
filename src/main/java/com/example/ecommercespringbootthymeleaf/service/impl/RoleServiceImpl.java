package com.example.ecommercespringbootthymeleaf.service.impl;

import com.example.ecommercespringbootthymeleaf.model.Role;
import com.example.ecommercespringbootthymeleaf.repository.RoleRepository;
import com.example.ecommercespringbootthymeleaf.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
  private final RoleRepository roleRepository;
  public Role save(Role role){
    return roleRepository.save(role);
  }
  public List<Role> findAll(){
    return roleRepository.findAll();
  }
}
