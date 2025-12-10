package com.example.easycare.controller;

import com.example.easycare.dto.ResponseDTO;
import com.example.easycare.model.Consultation;
import com.example.easycare.security.JwtService;
import com.example.easycare.service.Patientservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private Patientservice patientservice;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/upload-report")
    public ResponseEntity<ResponseDTO> uploadReport(@RequestHeader("Authorization") String token,
                                                    @RequestParam String patientId,
                                                    @RequestParam String reportFile) {
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid token", null));
        }
        String result = patientservice.uploadReport(patientId, reportFile);
        return ResponseEntity.ok(new ResponseDTO("success", result, null));
    }

    @GetMapping("/view-prescription")
    public ResponseEntity<ResponseDTO> viewPrescription(@RequestHeader("Authorization") String token,
                                                        @RequestParam String patientId) {
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDTO("error", "Invalid token", null));
        }
        String prescription = patientservice.viewPrescription(patientId);
        return ResponseEntity.ok(new ResponseDTO("success", "Prescription fetched", prescription));
    }

    @PostMapping("/book-consultation")
    public ResponseEntity<Consultation> bookConsultation(@RequestHeader("Authorization") String token,
                                                         @Valid @RequestBody Consultation consultation) {
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401).build();
        }
        Consultation saved = patientservice.bookConsultation(consultation);
        return ResponseEntity.ok(saved);
    }
}
