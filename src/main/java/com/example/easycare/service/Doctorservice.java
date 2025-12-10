package com.example.easycare.service;

import com.example.easycare.dto.MedicalRecordUpdateDTO;
import com.example.easycare.model.Patient;

public interface Doctorservice {
    Patient accessPatientData(String patientId);
    String provideEPrescription(String patientId, String prescription);
    String updateMedicalRecord(String recordId, MedicalRecordUpdateDTO dto);
}

