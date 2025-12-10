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

    @Autowired
    private Userservice userservice;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        String userId = userservice.login(loginDTO.getEmail(), loginDTO.getPassword());
        if (userId == null) {
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid credentials", null));
        }
        String token = jwtService.generateToken(userId);
        return ResponseEntity.ok(new ResponseDTO("success", "Login successful", token));
    }

    @PostMapping("/logout")
    public ResponseEntity<ResponseDTO> logout(@Valid @RequestBody LogoutDTO logoutDTO,
                                              @RequestHeader("Authorization") String token) {
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid token", null));
        }
        userservice.logout(logoutDTO.getUserId());
        return ResponseEntity.ok(new ResponseDTO("success", "Logged out successfully", null));
    }
}
