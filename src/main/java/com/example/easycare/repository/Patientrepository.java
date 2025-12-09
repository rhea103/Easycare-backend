package com.example.easycare.repository;

import com.example.easycare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patientrepository extends JpaRepository<Patient, String> {
}
