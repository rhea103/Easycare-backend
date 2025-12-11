package com.example.easycare.controller;

import com.example.easycare.dto.LoginDTO;
import com.example.easycare.dto.LogoutDTO;
import com.example.easycare.dto.ResponseDTO;
import com.example.easycare.security.JwtService;
import com.example.easycare.service.Userservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    // Injecting the Userservice to handle login and logout logic
    @Autowired
    private Userservice userservice;

    // Injecting JwtService to generate and validate JWT tokens
    @Autowired
    private JwtService jwtService;

    // Endpoint for user login
    // It receives email and password inside LoginDTO
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) {

        // Call the service to validate user credentials
        String userId = userservice.login(loginDTO.getEmail(), loginDTO.getPassword());

        // If credentials are wrong, return error response
        if (userId == null) {
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid credentials", null));
        }

        // If login is valid, generate a JWT token for the userId
        String token = jwtService.generateToken(userId);

        // Return success response with generated token
        return ResponseEntity.ok(new ResponseDTO("success", "Login successful", token));
    }

    // Endpoint for user logout
    // It requires a valid JWT token in the Authorization header
    @PostMapping("/logout")
    public ResponseEntity<ResponseDTO> logout(@Valid @RequestBody LogoutDTO logoutDTO,
                                              @RequestHeader("Authorization") String token) {

        // Token validation
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid token", null));
        }

        // Call service method to perform logout operation
        userservice.logout(logoutDTO.getUserId());

        // Return success response after logout
        return ResponseEntity.ok(new ResponseDTO("success", "Logged out successfully", null));
    }
}
