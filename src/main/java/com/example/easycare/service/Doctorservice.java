package com.example.easycare.service;

import com.example.easycare.model.MedicalRecord;
import com.example.easycare.model.Patient;
import com.example.easycare.repository.MedicalRecordrepository;
import com.example.easycare.repository.Patientrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Doctorservice {

    @Autowired
    private Patientrepository patientRepo;

    @Autowired
    private MedicalRecordrepository recordRepo;

    public Patient accessPatientData(String patientId) {
        return patientRepo.findById(patientId).orElse(null);
    }

    public String provideEPrescription(String patientId, String prescription) {
        MedicalRecord record = recordRepo.findByPatientId(patientId);
        if (record == null) return "Record not found";

        record.setPrescription(prescription);
        recordRepo.save(record);
        return "Prescription updated for patient " + patientId;
    }

    public String updateMedicalRecord(String recordId, MedicalRecord newRecord) {
        MedicalRecord existing = recordRepo.findById(recordId).orElse(null);

        if (existing == null) return "Record not found";

        existing.setDiagnosis(newRecord.getDiagnosis());
        existing.setReportFile(newRecord.getReportFile());
        existing.setPrescription(newRecord.getPrescription());
        recordRepo.save(existing);

        return "Record updated successfully";
    }
}

