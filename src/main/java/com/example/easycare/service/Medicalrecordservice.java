package com.example.easycare.service;

import com.example.easycare.dto.MedicalRecordDTO;
import com.example.easycare.model.MedicalRecord;

// Service interface for managing medical records
public interface MedicalRecordService {

    // Adds a new medical record using the provided DTO
    MedicalRecord addRecord(MedicalRecordDTO dto);

    // Retrieves a medical record by its record ID
    MedicalRecord getRecord(String recordId);
}
