
package com.example.easycare.repository;

import com.example.easycare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}


