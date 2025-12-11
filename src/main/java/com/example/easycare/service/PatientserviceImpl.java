package com.example.easycare.service;

import com.example.easycare.model.Consultation;
import com.example.easycare.model.Patient;
import com.example.easycare.repository.ConsultationRepository;
import com.example.easycare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// Implementation of the PatientService interface
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    // Allows a patient to upload a medical report
    @Override
    public String uploadReport(String patientId, String reportFile) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) return "Patient not found";

        // Assumes Patient entity has a list of reports
        patient.getReports().add(reportFile);
        patientRepository.save(patient);
        return "Report uploaded successfully";
    }

    // Allows a patient to view their prescription
    @Override
    public String viewPrescription(String patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) return "Patient not found";

        return patient.getPrescription(); // Assumes Patient entity has a prescription field
    }

    // Allows a patient to book a consultation
    @Override
    public Consultation bookConsultation(Consultation consultation) {
        consultation.setStatus("Scheduled"); // Default status when booking
        return consultationRepository.save(consultation);
    }
}
