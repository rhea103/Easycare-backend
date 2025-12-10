package com.example.easycare.service;

import com.example.easycare.dto.MedicalRecordDTO;
import com.example.easycare.model.MedicalRecord;

public interface Medicalrecordservice {
    MedicalRecord addRecord(MedicalRecordDTO dto);
    MedicalRecord getRecord(String recordId);
}
