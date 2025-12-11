package com.example.easycare.controller;

import com.example.easycare.dto.MedicalRecordUpdateDTO;      // DTO for updating medical records
import com.example.easycare.dto.PrescriptionDTO;             // DTO for creating prescriptions
import com.example.easycare.model.Patient;                   // Patient entity returned in accessPatient
import com.example.easycare.security.JwtService;             // Service for validating JWT tokens
import com.example.easycare.service.Doctorservice;           // Service containing doctor-related logic
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                                              // Marks the class as a REST API controller
@RequestMapping("/doctor")                                   // Base URL → all endpoints start with /doctor
public class DoctorController {

    @Autowired
    private Doctorservice doctorservice;                     // Inject Doctorservice for business logic

    @Autowired
    private JwtService jwtService;                           // Inject JwtService to validate tokens

    //  ACCESS PATIENT DATA 
    @GetMapping("/access-patient")
    public ResponseEntity<Patient> accessPatient(
            @RequestHeader("Authorization") String token,    // JWT token from request header
            @RequestParam String patientId                   // Patient ID passed as a query parameter
    ) {
        // If token is invalid then return 401 Unauthorized
        if (!jwtService.validateToken(token)) 
            return ResponseEntity.status(401).build();

        // Call service to access the patient's data
        Patient patient = doctorservice.accessPatientData(patientId);

        // Return patient information
        return ResponseEntity.ok(patient);
    }

    //  PROVIDE E-PRESCRIPTION 
    @PostMapping("/prescribe")
    public ResponseEntity<String> prescribe(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody PrescriptionDTO dto          // DTO containing patient ID + prescription text
    ) {
        // Validate token
        if (!jwtService.validateToken(token)) 
            return ResponseEntity.status(401).build();

        // Call service to issue an electronic prescription
        String result = doctorservice.provideEPrescription(dto.getPatientId(), dto.getPrescription());

        // Return success response
        return ResponseEntity.ok(result);
    }

    //UPDATE MEDICAL RECORD 
    @PutMapping("/update-record")
    public ResponseEntity<String> updateRecord(
            @RequestHeader("Authorization") String token,
            @RequestParam String recordId,                    // Record ID to update
            @Valid @RequestBody MedicalRecordUpdateDTO dto    // DTO with updated data
    ) {
        // If token invalid then return 401
        if (!jwtService.validateToken(token)) 
            return ResponseEntity.status(401).build();

        // Update the medical record via service method
        String result = doctorservice.updateMedicalRecord(recordId, dto);

        // Return success message
        return ResponseEntity.ok(result);
    }
}
