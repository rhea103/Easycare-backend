package com.example.easycare.service;

import com.example.easycare.model.Consultation;

public interface Patientservice {
    String uploadReport(String patientId, String reportFile);
    String viewPrescription(String patientId);
    Consultation bookConsultation(Consultation consultation);
}
