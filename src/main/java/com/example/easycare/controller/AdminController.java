package com.example.easycare.controller;

import com.example.easycare.dto.ResponseDTO;
import com.example.easycare.security.JwtService;
import com.example.easycare.service.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                              // Marks this class as a REST API controller
@RequestMapping("/admin")                     // Base URL for all admin endpoints
public class AdminController {

    @Autowired
    private Adminservice adminservice;        // Service layer that contains admin-related logic

    @Autowired
    private JwtService jwtService;            // Service for validating JWT tokens

    // MANAGE USERS 
    @GetMapping("/manage-users")
    public ResponseEntity<ResponseDTO> manageUsers(@RequestHeader("Authorization") String token) {

        // Validate the JWT token received from the frontend
        if (!jwtService.validateToken(token)) {
            // If token is invalid -> return 401 Unauthorized
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid token", null));
        }

        // Call service method to perform user management logic
        String result = adminservice.manageUsers();

        // Return success response
        return ResponseEntity.ok(new ResponseDTO("success", result, null));
    }

    //ENSURE SECURITY 
    @GetMapping("/ensure-security")
    public ResponseEntity<ResponseDTO> ensureSecurity(@RequestHeader("Authorization") String token) {

        // Validate token
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid token", null));
        }

        // Perform security checks via the service
        String result = adminservice.ensureSecurity();

        // Return success response
        return ResponseEntity.ok(new ResponseDTO("success", result, null));
    }

    //BACKUP DATA 
    @GetMapping("/backup")
    public ResponseEntity<ResponseDTO> backup(@RequestHeader("Authorization") String token) {

        // Validate token
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid token", null));
        }

        // Perform database backup logic
        String result = adminservice.backupData();

        // Return success response
        return ResponseEntity.ok(new ResponseDTO("success", result, null));
    }
}
