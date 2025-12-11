package com.example.easycare.repository;

import com.example.easycare.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for MedicalRecord entity
// Extends JpaRepository to provide CRUD operations
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, String> {

    // Finds a medical record by the patient's ID
    MedicalRecord findByPatientId(String patientId);
}



