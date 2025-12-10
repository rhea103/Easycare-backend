package com.example.easycare.controller;

import com.example.easycare.dto.MedicalRecordUpdateDTO;
import com.example.easycare.dto.PrescriptionDTO;
import com.example.easycare.model.Patient;
import com.example.easycare.security.JwtService;
import com.example.easycare.service.Doctorservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private Doctorservice doctorservice;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/access-patient")
    public ResponseEntity<Patient> accessPatient(@RequestHeader("Authorization") String token,
                                                 @RequestParam String patientId) {
        if (!jwtService.validateToken(token)) return ResponseEntity.status(401).build();
        return ResponseEntity.ok(doctorservice.accessPatientData(patientId));
    }

    @PostMapping("/prescribe")
    public ResponseEntity<String> prescribe(@RequestHeader("Authorization") String token,
                                            @Valid @RequestBody PrescriptionDTO dto) {
        if (!jwtService.validateToken(token)) return ResponseEntity.status(401).build();
        return ResponseEntity.ok(doctorservice.provideEPrescription(dto.getPatientId(), dto.getPrescription()));
    }

    @PutMapping("/update-record")
    public ResponseEntity<String> updateRecord(@RequestHeader("Authorization") String token,
                                               @RequestParam String recordId,
                                               @Valid @RequestBody MedicalRecordUpdateDTO dto) {
        if (!jwtService.validateToken(token)) return ResponseEntity.status(401).build();
        return ResponseEntity.ok(doctorservice.updateMedicalRecord(recordId, dto));
    }
}


