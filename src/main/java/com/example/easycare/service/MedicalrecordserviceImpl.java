package com.example.easycare.service;

import com.example.easycare.dto.MedicalRecordDTO;
import com.example.easycare.model.MedicalRecord;
import com.example.easycare.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// Implementation of the MedicalRecordService interface
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordRepository recordRepository;

    // Adds a new medical record using the provided DTO
    @Override
    public MedicalRecord addRecord(MedicalRecordDTO dto) {
        MedicalRecord record = new MedicalRecord();
        record.setPatientId(dto.getPatientId());
        record.setDiagnosis(dto.getDiagnosis());
        record.setTreatment(dto.getTreatment());
        // You can also set dateCreated if your entity has it
        return recordRepository.save(record);
    }

    // Retrieves a medical record by its record ID
    @Override
    public MedicalRecord getRecord(String recordId) {
        return recordRepository.findById(recordId).orElse(null);
        // Consider returning Optional<MedicalRecord> for safer handling
    }
}
