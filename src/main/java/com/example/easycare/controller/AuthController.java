package com.example.easycare.controller;

import com.example.easycare.controller.dto.LoginRequest;
import com.example.easycare.controller.dto.LoginResponse;
import com.example.easycare.model.User;
import com.example.easycare.repository.UserRepository;
import com.example.easycare.service.Userservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                               // Marks this class as a REST controller
@RequestMapping("/api/auth")                  // Base URL for all authentication endpoints
public class AuthController {

    @Autowired
    private Userservice userService;          // Service that handles login logic + token generation

    @Autowired
    private UserRepository userRepository;    // Repository to fetch user details from DB

    //LOGIN ENDPOINT 
    @PostMapping("/login")                    // HTTP POST :/api/auth/login
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {

        // Call service layer to validate email/password and get JWT token
        String token = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

        // If token is null then login failed (invalid credentials)
        if (token == null) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        // Fetch user from the database using email
        User user = userRepository.findByEmail(loginRequest.getEmail());

        // Return token + user id + user role as LoginResponse object
        return ResponseEntity.ok(
                new LoginResponse(
                        token,
                        user.getId(),
                        user.getRole().name()    // Convert Enum to String
                )
        );
    }
}
