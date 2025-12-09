package com.example.easycare.service;

import com.example.easycare.model.Consultation;
import com.example.easycare.model.MedicalRecord;
import com.example.easycare.repository.Consultationrepository;
import com.example.easycare.repository.MedicalRecordrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import lombok.Data;

@Service
public class Patientservice {

    @Autowired
    private MedicalRecordrepository recordRepo;

    @Autowired
    private Consultationrepository consultationRepo;

    public String uploadReport(String patientId, String reportFile) {
        MedicalRecord record = new MedicalRecord();
        record.setRecordID(UUID.randomUUID().toString());
        record.setReportFile(reportFile);

        recordRepo.save(record);
        return "Report uploaded for patient " + patientId;
    }

    public String viewPrescription(String patientId) {
        MedicalRecord record = recordRepo.findByPatientId(patientId);
        if (record == null) return "No prescription found";
        return record.getPrescription();
    }

    public Consultation bookConsultation(Consultation consultation) {
        consultation.setConsultationID(UUID.randomUUID().toString());
        return consultationRepo.save(consultation);
    }
}

