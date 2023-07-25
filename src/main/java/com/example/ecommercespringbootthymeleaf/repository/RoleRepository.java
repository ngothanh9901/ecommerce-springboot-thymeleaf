package com.example.ecommercespringbootthymeleaf.repository;

import com.example.ecommercespringbootthymeleaf.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role,Long> {
}