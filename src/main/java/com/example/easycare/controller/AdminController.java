package com.example.easycare.controller;

import com.example.easycare.service.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private Adminservice adminservice;

    @GetMapping("/manage-users")
    public String manageUsers() {
        return adminservice.manageUsers();
    }

    @GetMapping("/ensure-security")
    public String ensureSecurity() {
        return adminservice.ensureSecurity();
    }

    @GetMapping("/backup")
    public String backup() {
        return adminservice.backupData();
    }
}
