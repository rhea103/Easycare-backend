package com.example.easycare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    // Primary key for the MedicalRecord entity
    @Id
    private String recordID;

    // Stores the diagnosis details for the patient
    private String diagnosis;

    // Stores the file path or URL of the medical report
    private String reportFile;

    // Stores the prescription details for the patient
    private String prescription;
}
