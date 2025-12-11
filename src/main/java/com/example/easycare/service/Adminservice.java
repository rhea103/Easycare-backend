package com.example.easycare.service;

// Service interface for Admin-related operations
public interface AdminService {

    // Method to manage users (e.g., create, update, delete)
    String manageUsers();

    // Method to ensure system security
    String ensureSecurity();

    // Method to backup system data
    String backupData();
}
