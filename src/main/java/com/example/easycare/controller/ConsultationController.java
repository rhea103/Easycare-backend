package com.example.easycare.controller;

import com.example.easycare.dto.ConsultationRequestDTO;
import com.example.easycare.model.Consultation;
import com.example.easycare.security.JwtService;
import com.example.easycare.service.Consultationservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private Consultationservice consultationservice;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/schedule")
    public ResponseEntity<Consultation> schedule(@RequestHeader("Authorization") String token,
                                                 @Valid @RequestBody ConsultationRequestDTO dto) {
        if (!jwtService.validateToken(token)) return ResponseEntity.status(401).build();

        Consultation consultation = consultationservice.scheduleConsultation(dto);
        return ResponseEntity.ok(consultation);
    }

    @PostMapping("/start")
    public ResponseEntity<String> start(@RequestHeader("Authorization") String token,
                                        @RequestParam String id) {
        if (!jwtService.validateToken(token)) return ResponseEntity.status(401).build();

        String result = consultationservice.startConsultation(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/end")
    public ResponseEntity<String> end(@RequestHeader("Authorization") String token,
                                      @RequestParam String id) {
        if (!jwtService.validateToken(token)) return ResponseEntity.status(401).build();

        String result = consultat
