package com.example.easycare.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
@Data
@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    private String recordID;

    private String diagnosis;
    private String reportFile;
    private String prescription;
}
