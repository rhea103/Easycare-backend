package com.example.easycare.controller;

import com.example.easycare.dto.ResponseDTO;                // Generic response object (status, message, data)
import com.example.easycare.model.Consultation;             // Consultation entity used for booking
import com.example.easycare.security.JwtService;            // Service used to validate JWT tokens
import com.example.easycare.service.Patientservice;         // Service class handling patient-related operations
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                                             // Marks this class as a REST API controller
@RequestMapping("/patient")                                 // Base URL → all endpoints start with /patient
public class PatientController {

    @Autowired
    private Patientservice patientservice;                  // Inject Patientservice (business logic)

    @Autowired
    private JwtService jwtService;                          // Inject JwtService for token validation

    // UPLOAD MEDICAL REPORT 
    @PostMapping("/upload-report")
    public ResponseEntity<ResponseDTO> uploadReport(
            @RequestHeader("Authorization") String token,   // JWT token from request header
            @RequestParam String patientId,                 // ID of the patient uploading the report
            @RequestParam String reportFile                 // File path or file name (string)
    ) {
        // Validate JWT token ( return 401 Unauthorized if invalid)
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid token", null));
        }

        // Call service to upload the patient's report
        String result = patientservice.uploadReport(patientId, reportFile);

        // Return success with message
        return ResponseEntity.ok(new ResponseDTO("success", result, null));
    }

    //  VIEW PRESCRIPTIONS
    @GetMapping("/view-prescription")
    public ResponseEntity<ResponseDTO> viewPrescription(
            @RequestHeader("Authorization") String token,
            @RequestParam String patientId                  // Patient ID whose prescription needs to be viewed
    ) {
        // Validate token
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid token", null));
        }

        // Fetch prescription details from service
        String prescription = patientservice.viewPrescription(patientId);

        // Return prescription as part of ResponseDTO
        return ResponseEntity.ok(new ResponseDTO("success", "Prescription fetched", prescription));
    }

    //  BOOK CONSULTATION
    @PostMapping("/book-consultation")
    public ResponseEntity<Consultation> bookConsultation(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody Consultation consultation   // Consultation details sent by the patient
    ) {
        // Validate token
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401).build();
        }

        // Save the consultation request in the database
        Consultation saved = patientservice.bookConsultation(consultation);

        // Return the saved consultation object
        return ResponseEntity.ok(saved);
    }
}
