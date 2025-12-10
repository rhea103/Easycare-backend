package com.example.easycare.controller;

import com.example.easycare.dto.MedicalRecordDTO;
import com.example.easycare.model.MedicalRecord;
import com.example.easycare.security.JwtService;
import com.example.easycare.service.Medicalrecordservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class MedicalRecordController {

    @Autowired
    private Medicalrecordservice recordservice;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/add")
    public ResponseEntity<MedicalRecord> addRecord(@RequestHeader("Authorization") String token,
                                                   @Valid @RequestBody MedicalRecordDTO dto) {
        if (!jwtService.validateToken(token)) return ResponseEntity.status(401).build();

        MedicalRecord record = recordservice.addRecord(dto);
        return ResponseEntity.ok(record);
    }

    @GetMapping("/get")
    public ResponseEntity<MedicalRecord> getRecord(@RequestHeader("Authorization") String token,
                                                   @RequestParam String recordId) {
        if (!jwtService.validateToken(token)) return ResponseEntity.status(401).build();

        MedicalRecord record = recordservice.getRecord(recordId);
        return ResponseEntity.ok(record);
    }
}
