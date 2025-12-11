package com.example.easycare.repository;

import com.example.easycare.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
// Repository interface for Admin entity
// Extends JpaRepository to provide CRUD operations
public interface Adminrepository extends JpaRepository<Admin, String> {
}
