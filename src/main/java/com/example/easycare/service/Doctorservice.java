package com.example.easycare.service;

import com.example.easycare.dto.MedicalRecordUpdateDTO;
import com.example.easycare.model.Patient;

// Service interface for Doctor-related operations
public interface DoctorService {

    // Allows a doctor to access patient data by patient ID
    Patient accessPatientData(String patientId);

    // Allows a doctor to provide an e-prescription for a patient
    String provideEPrescription(String patientId, String prescription);

    // Allows a doctor to update a medical record by record ID
    String updateMedicalRecord(String recordId, MedicalRecordUpdateDTO dto);
}
