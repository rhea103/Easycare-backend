package com.example.easycare.controller;

import com.example.easycare.dto.ResponseDTO;
import com.example.easycare.security.JwtService;
import com.example.easycare.service.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private Adminservice adminservice;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/manage-users")
    public ResponseEntity<ResponseDTO> manageUsers(@RequestHeader("Authorization") String token) {
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401).body(new ResponseDTO("error", "Invalid token", null));
        }
        String result = adminservice.manageUsers();
        return ResponseEntity.ok(new ResponseDTO("success", result, null));
    }

    @GetMapping("/ensure-security")
    public ResponseEntity<ResponseDTO> ensureSecurity(@RequestHeader("Authorization") String token) {
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401).body(new ResponseDTO("error", "Invalid token", null));
        }
        String result = adminservice.ensureSecurity();
        return ResponseEntity.ok(new ResponseDTO("success", result, null));
    }

    @GetMapping("/backup")
    public ResponseEntity<ResponseDTO> backup(@RequestHeader("Authorization") String token) {
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401).body(new ResponseDTO("error", "Invalid token", null));
        }
        String result = adminservice.backupData();
        return ResponseEntity.ok(new ResponseDTO("success", result, null));
    }
}
