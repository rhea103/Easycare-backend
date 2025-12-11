package com.example.easycare.service;

import com.example.easycare.dto.MedicalRecordUpdateDTO;
import com.example.easycare.model.MedicalRecord;
import com.example.easycare.model.Patient;
import com.example.easycare.repository.MedicalRecordRepository;
import com.example.easycare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// Implementation of the DoctorService interface
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicalRecordRepository recordRepository;

    // Allows a doctor to access patient data by patient ID
    @Override
    public Patient accessPatientData(String patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    // Allows a doctor to provide an e-prescription for a patient
    @Override
    public String provideEPrescription(String patientId, String prescription) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) return "Patient not found";

        patient.setPrescription(prescription); // Assumes Patient entity has a prescription field
        patientRepository.save(patient);
        return "Prescription added successfully";
    }

    // Allows a doctor to update a medical record by record ID
    @Override
    public String updateMedicalRecord(String recordId, MedicalRecordUpdateDTO dto) {
        MedicalRecord record = recordRepository.findById(recordId).orElse(null);
        if (record == null) return "Record not found";

        record.setDiagnosis(dto.getDiagnosis());
        record.setTreatment(dto.getTreatment());
        recordRepository.save(record);
        return "Record updated successfully";
    }
}

