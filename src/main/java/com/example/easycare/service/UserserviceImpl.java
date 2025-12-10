package com.example.easycare.service;

import com.example.easycare.model.User;
import com.example.easycare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl implements Userservice {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) return null;
        return user.getId();
    }

    @Override
    public void logout(String userId) {
        // Example logic: you can add token invalidation here if needed
    }
}
