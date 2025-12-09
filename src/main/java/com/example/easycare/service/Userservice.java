package com.example.easycare.service;

import com.example.easycare.model.User;
import com.example.easycare.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;

@Service
public class Userservice {

    @Autowired
    private Userrepository userRepo;

    public String login(String email, String password) {
        User user = userRepo.findByEmail(email);

        if (user == null)
            return "User not found";

        if (!user.getPassword().equals(password))
            return "Incorrect password";

        return "Login successful";
    }

    public String logout(String userId) {
        return "User " + userId + " logged out";
    }
}
