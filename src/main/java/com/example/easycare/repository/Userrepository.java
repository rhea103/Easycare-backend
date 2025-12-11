package com.example.easycare.repository;

import com.example.easycare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Repository interface for User entity
// Extends JpaRepository to provide CRUD operations
public interface UserRepository extends JpaRepository<User, String> {

    // Finds a user by their email
    Optional<User> findByEmail(String email);
}



