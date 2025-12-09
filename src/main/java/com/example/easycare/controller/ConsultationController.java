package com.example.easycare.controller;

import com.example.easycare.model.Consultation;
import com.example.easycare.service.Consultationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private Consultationservice consultationservice;

    @PostMapping("/schedule")
    public Consultation schedule(@RequestBody Consultation c) {
        return consultationservice.scheduleConsultation(c);
    }

    @PostMapping("/start")
    public String start(@RequestParam String id) {
        return consultationservice.startConsultation(id);
    }

    @PostMapping("/end")
    public String end(@RequestParam String id) {
        return consultationservice.endConsultation(id);
    }
}
