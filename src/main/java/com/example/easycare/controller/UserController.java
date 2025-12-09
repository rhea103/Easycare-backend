package com.example.easycare.controller;

import com.example.easycare.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Userservice userservice;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return userservice.login(email, password);
    }

    @PostMapping("/logout")
    public String logout(@RequestParam String userId) {
        return userservice.logout(userId);
    }
}
