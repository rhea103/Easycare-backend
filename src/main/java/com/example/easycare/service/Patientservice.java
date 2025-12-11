package com.example.easycare.service;

import com.example.easycare.model.Consultation;

// Service interface for Patient-related operations
public interface PatientService {

    // Allows a patient to upload a medical report file
    String uploadReport(String patientId, String reportFile);

    // Allows a patient to view their prescription
    String viewPrescription(String patientId);

    // Allows a patient to book a consultation
    Consultation bookConsultation(Consultation consultation);
}
