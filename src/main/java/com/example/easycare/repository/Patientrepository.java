package com.example.easycare.repository;

import com.example.easycare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
// Repository interface for Patient entity
// Extends JpaRepository to provide CRUD operations
public interface Patientrepository extends JpaRepository<Patient, String> {
}
