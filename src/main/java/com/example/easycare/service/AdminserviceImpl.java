package com.example.easycare.service;

import org.springframework.stereotype.Service;

@Service
public class AdminserviceImpl implements Adminservice {

    @Override
    public String manageUsers() {
        // Example logic
        return "Users managed successfully";
    }

    @Override
    public String ensureSecurity() {
        return "Security ensured";
    }

    @Override
    public String backupData() {
        return "Data backup completed";
    }
}
