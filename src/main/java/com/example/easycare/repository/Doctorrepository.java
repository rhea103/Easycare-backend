package com.example.easycare.repository;

import com.example.easycare.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Doctorrepository extends JpaRepository<Doctor, String> {
}

