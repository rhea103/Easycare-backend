package com.example.easycare.service;

import com.example.easycare.model.User;
import com.example.easycare.repository.UserRepository;
import com.example.easycare.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
// Implementation of the UserService interface
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder; // e.g., BCryptPasswordEncoder

    // Handles user login and returns a JWT token if successful
    @Override
    public String login(String email, String password) {

        // 1. Find user by email
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return null;

        // 2. Compare hashed password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return null;
        }

        // 3. Generate JWT token including user role
        return jwtService.generateToken(user.getUserID(), user.getRole());
    }

    // Handles user logout (implementation depends on token invalidation strategy)
    @Override
    public void logout(String userId) {
        // If using stateless JWTs, logout can be handled on the client side
        // Optionally, implement a token blacklist for server-side logout
    }
}
