package com.example.easycare.security;

import java.security.SecureRandom;
import java.util.Base64;

public class KeyGenerator {

    public static void main(String[] args) {

        // Create a secure random number generator
        SecureRandom random = new SecureRandom();

        // Generate 64 random bytes for the secret key
        byte[] bytes = new byte[64];
        random.nextBytes(bytes);

        // Encode the byte array into a Base64 string
        String secretKey = Base64.getEncoder().encodeToString(bytes);

        // Print the generated secret key
        System.out.println("Your JWT Secret Key:");
        System.out.println(secretKey);
    }
}
