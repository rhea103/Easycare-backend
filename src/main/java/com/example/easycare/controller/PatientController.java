package com.example.easycare.controller;

import com.example.easycare.model.Consultation;
import com.example.easycare.service.Patientservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private Patientservice patientservice;

    @PostMapping("/upload-report")
    public String uploadReport(@RequestParam String patientId,
                               @RequestParam String reportFile) {
        return patientservice.uploadReport(patientId, reportFile);
    }

    @GetMapping("/view-prescription")
    public String viewPrescription(@RequestParam String patientId) {
        return patientservice.viewPrescription(patientId);
    }

    @PostMapping("/book-consultation")
    public Consultation bookConsultation(@RequestBody Consultation consultation) {
        return patientservice.bookConsultation(consultation);
    }
}
