package com.example.easycare.dto;

public class LoginResponseDTO {

    // Stores the JWT token returned after successful login
    private String token;

    // Stores the ID of the logged-in user
    private String userId;

    // Stores the role of the user (e.g., ADMIN, DOCTOR, PATIENT)
    private String role;

    // Constructor to initialize all fields
    public LoginResponseDTO(String token, String userId, String role) {
        this.token = token;
        this.userId = userId;
        this.role = role;
    }

} 