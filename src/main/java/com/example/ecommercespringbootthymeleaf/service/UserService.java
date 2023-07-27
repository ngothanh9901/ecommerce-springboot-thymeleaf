package com.example.ecommercespringbootthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.ecommercespringbootthymeleaf.model.Users;
import com.example.ecommercespringbootthymeleaf.payload.request.UserRequest;
import com.example.ecommercespringbootthymeleaf.repository.UserRepository;

public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired 
    PasswordEncoder passwordEncoder;

    public void reigsterUser(UserRequest userRequest) {
        Users user = Users.builder()
                .name(userRequest.name)
                .username(userRequest.username)
                .email(userRequest.password)
                .password(this.passwordEncoder.encode(userRequest.password))
                .build();
        userRepository.save(user);
    }
}
