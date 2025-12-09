package com.example.easycare.controller;

import com.example.easycare.model.MedicalRecord;
import com.example.easycare.service.Medicalrecordservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class MedicalRecordController {

    @Autowired
    private Medicalrecordservice recordservice;

    @PostMapping("/add")
    public MedicalRecord addRecord(@RequestBody MedicalRecord record) {
        return recordservice.addRecord(record);
    }

    @GetMapping("/get")
    public MedicalRecord getRecord(@RequestParam String recordId) {
        return recordservice.getRecord(recordId);
    }
}
