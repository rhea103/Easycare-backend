package com.example.easycare.repository;

import com.example.easycare.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
// Repository interface for Doctor entity
// Extends JpaRepository to provide CRUD operations
public interface Doctorrepository extends JpaRepository<Doctor, String> {
}

