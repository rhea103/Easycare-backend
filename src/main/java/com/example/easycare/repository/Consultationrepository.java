package com.example.easycare.repository;

import com.example.easycare.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
// Repository interface for Consultation entity
// Extends JpaRepository to provide CRUD operations
public interface Consultationrepository extends JpaRepository<Consultation, String> {
}
