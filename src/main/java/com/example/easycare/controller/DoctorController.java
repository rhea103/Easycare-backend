package com.example.easycare.controller;

import com.example.easycare.model.MedicalRecord;
import com.example.easycare.model.Patient;
import com.example.easycare.service.Doctorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private Doctorservice doctorservice;

    @GetMapping("/access-patient")
    public Patient accessPatient(@RequestParam String patientId) {
        return doctorservice.accessPatientData(patientId);
    }

    @PostMapping("/prescribe")
    public String prescribe(@RequestParam String patientId,
                            @RequestParam String prescription) {
        return doctorservice.provideEPrescription(patientId, prescription);
    }

    @PutMapping("/update-record")
    public String updateRecord(@RequestParam String recordId,
                               @RequestBody MedicalRecord newRecord) {
        return doctorservice.updateMedicalRecord(recordId, newRecord);
    }
}
