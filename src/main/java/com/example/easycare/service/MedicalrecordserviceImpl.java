package com.example.easycare.service;

import com.example.easycare.dto.MedicalRecordDTO;
import com.example.easycare.model.MedicalRecord;
import com.example.easycare.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalrecordserviceImpl implements Medicalrecordservice {

    @Autowired
    private MedicalRecordRepository recordRepository;

    @Override
    public MedicalRecord addRecord(MedicalRecordDTO dto) {
        MedicalRecord record = new MedicalRecord();
        record.setPatientId(dto.getPatientId());
        record.setDiagnosis(dto.getDiagnosis());
        record.setTreatment(dto.getTreatment());
        return recordRepository.save(record);
    }

    @Override
    public MedicalRecord getRecord(String recordId) {
        return recordRepository.findById(recordId).orElse(null);
    }
}
