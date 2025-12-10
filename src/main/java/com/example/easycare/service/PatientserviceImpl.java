package com.example.easycare.service;

import com.example.easycare.model.Consultation;
import com.example.easycare.model.Patient;
import com.example.easycare.repository.ConsultationRepository;
import com.example.easycare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientserviceImpl implements Patientservice {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public String uploadReport(String patientId, String reportFile) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) return "Patient not found";

        patient.getReports().add(reportFile);
        patientRepository.save(patient);
        return "Report uploaded successfully";
    }

    @Override
    public String viewPrescription(String patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) return "Patient not found";

        return patient.getPrescription();
    }

    @Override
    public Consultation bookConsultation(Consultation consultation) {
        consultation.setStatus("Scheduled");
        return consultationRepository.save(consultation);
    }
}
