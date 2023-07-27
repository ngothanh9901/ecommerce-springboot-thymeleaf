package com.example.ecommercespringbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecommercespringbootthymeleaf.payload.request.UserRequest;
import com.example.ecommercespringbootthymeleaf.service.UserService;

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody UserRequest requestBody){
        userService.reigsterUser(requestBody);
    }
}
