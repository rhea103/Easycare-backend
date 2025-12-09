package com.example.easycare.service;

import org.springframework.stereotype.Service;

@Service
public class Adminservice {

    public String manageUsers() {
        return "Users managed successfully";
    }

    public String ensureSecurity() {
        return "Security ensured successfully";
    }

    public String backupData() {
        return "Database backup complete";
    }
}
