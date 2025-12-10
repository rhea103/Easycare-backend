package com.example.easycare.security;

import java.security.SecureRandom;
import java.util.Base64;

public class KeyGenerator {
    public static void main(String[] args) {
        // Step 1: Create a secure random number generator
        SecureRandom random = new SecureRandom();

        // Step 2: Create a byte array of 64 bytes (512 bits)
        byte[] bytes = new byte[64];
        random.nextBytes(bytes);

        // Step 3: Encode the bytes to a Base64 string
        String secretKey = Base64.getEncoder().encodeToString(bytes);

        // Step 4: Print the secret key
        System.out.println("Your JWT Secret Key:");
        System.out.println(secretKey);
    }
}
