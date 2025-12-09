package com.example.easycare.repository;

import com.example.easycare.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Consultationrepository extends JpaRepository<Consultation, String> {
}
