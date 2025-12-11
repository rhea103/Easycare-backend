package com.example.easycare.service;

public interface Userservice {
    /**
     * Authenticate a user (Patient, Doctor, Admin) and return a JWT token.
     * @param email User email
     * @param password User password
     * @return JWT token if login successful, null otherwise
     */
    String login(String email, String password);

    /**
     * Optional: Logout a user (token invalidation if implemented)
     * @param userId
     */
    void logout(String userId);
}
