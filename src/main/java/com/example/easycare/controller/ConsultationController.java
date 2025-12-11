package com.example.easycare.controller;

import com.example.easycare.dto.ConsultationRequestDTO;      // DTO for consultation scheduling
import com.example.easycare.model.Consultation;              // Entity returned after scheduling
import com.example.easycare.security.JwtService;             // JWT validator
import com.example.easycare.service.Consultationservice;     // Service layer for consultation logic
import jakarta.validation.Valid;                             
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                                              // Marks this class as a REST Controller
@RequestMapping("/consultation")                             // Base URL -> /consultation/..
public class ConsultationController {

    @Autowired
    private Consultationservice consultationservice;         // Consultation service (business logic)

    @Autowired
    private JwtService jwtService;                           // Token validation service

    //SCHEDULE CONSULTATION 
    @PostMapping("/schedule")
    public ResponseEntity<Consultation> schedule(
            @RequestHeader("Authorization") String token,    // JWT token sent by the client
            @Valid @RequestBody ConsultationRequestDTO dto   // Request body containing consultation details
    ) {
        // Validate JWT token. If invalid -> return 401 Unauthorized
        if (!jwtService.validateToken(token)) 
            return ResponseEntity.status(401).build();

        // Call service to schedule consultation and return the saved consultation
        Consultation consultation = consultationservice.scheduleConsultation(dto);

        // Return the created consultation as response
        return ResponseEntity.ok(consultation);
    }

    // START CONSULTATION 
    @PostMapping("/start")
    public ResponseEntity<String> start(
            @RequestHeader("Authorization") String token,
            @RequestParam String id                         // Consultation ID passed as query param
    ) {
        // Validate JWT token
        if (!jwtService.validateToken(token)) 
            return ResponseEntity.status(401).build();

        // Start the consultation using service
        String result = consultationservice.startConsultation(id);

        // Return result message
        return ResponseEntity.ok(result);
    }

    //  END CONSULTATION
    @PostMapping("/end")
    public ResponseEntity<String> end(
            @RequestHeader("Authorization") String token,
            @RequestParam String id                         // Consultation ID passed as query param
    ) {
        // Validate token
        if (!jwtService.validateToken(token)) 
            return ResponseEntity.status(401).build();

        // End consultation using service
        String result = consultationservice.endConsultation(id);

        // Return result message
        return ResponseEntity.ok(result);
    }
}
