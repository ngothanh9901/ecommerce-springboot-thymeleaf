package com.example.ecommercespringbootthymeleaf.service.impl;

import com.example.ecommercespringbootthymeleaf.model.Role;
import com.example.ecommercespringbootthymeleaf.model.Users;
import com.example.ecommercespringbootthymeleaf.repository.RoleRepository;
import com.example.ecommercespringbootthymeleaf.repository.UserRepository;
import com.example.ecommercespringbootthymeleaf.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    public Users register(Users user){
        String newPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(newPassword);

        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByCode("Admin");
        roles.add(role);

        user.setRoles(roles);
        return userRepository.save(user);
    }
}
