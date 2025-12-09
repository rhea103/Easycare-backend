package com.example.easycare.repository;

import com.example.easycare.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordrepository extends JpaRepository<MedicalRecord, String> {
    MedicalRecord findByPatientId(String patientId);
}

