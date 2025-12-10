package com.example.easycare.service;

public interface Userservice {
    String login(String email, String password);
    void logout(String userId);
}
