package com.example.easycare.service;

import com.example.easycare.model.MedicalRecord;
import com.example.easycare.repository.MedicalRecordrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Medicalrecordservice {

    @Autowired
    private MedicalRecordrepository recordRepo;

    public MedicalRecord addRecord(MedicalRecord record) {
        record.setRecordID(UUID.randomUUID().toString());
        return recordRepo.save(record);
    }

    public MedicalRecord getRecord(String recordId) {
        return recordRepo.findById(recordId).orElse(null);
    }
}
