package com.example.easycare.controller;

import com.example.easycare.dto.MedicalRecordDTO;           // DTO for creating a new medical record
import com.example.easycare.model.MedicalRecord;            // MedicalRecord entity returned in responses
import com.example.easycare.security.JwtService;            // JWT validator for secured endpoints
import com.example.easycare.service.Medicalrecordservice;   // Service layer handling record logic
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                                              // Marks this class as a REST API controller
@RequestMapping("/record")                                   // Base URL -> all endpoints start with /record
public class MedicalRecordController {

    @Autowired
    private Medicalrecordservice recordservice;              // Inject service that handles medical records

    @Autowired
    private JwtService jwtService;                           // Inject JWT service for token validation

    //  ADD MEDICAL RECORD
    @PostMapping("/add")
    public ResponseEntity<MedicalRecord> addRecord(
            @RequestHeader("Authorization") String token,     // JWT token from client
            @Valid @RequestBody MedicalRecordDTO dto          // DTO containing details of new medical record
    ) {
        // Validate JWT token (unauthorized if incorrect)
        if (!jwtService.validateToken(token)) 
            return ResponseEntity.status(401).build();

        // Call service to add a new medical record into the database
        MedicalRecord record = recordservice.addRecord(dto);

        // Return saved medical record
        return ResponseEntity.ok(record);
    }

    //GET MEDICAL RECORD 
    @GetMapping("/get")
    public ResponseEntity<MedicalRecord> getRecord(
            @RequestHeader("Authorization") String token,
            @RequestParam String recordId                    // Record ID passed as a query parameter
    ) {
        // Validate token
        if (!jwtService.validateToken(token)) 
            return ResponseEntity.status(401).build();

        // Fetch medical record by ID
        MedicalRecord record = recordservice.getRecord(recordId);

        // Return fetched record
        return ResponseEntity.ok(record);
    }
}
