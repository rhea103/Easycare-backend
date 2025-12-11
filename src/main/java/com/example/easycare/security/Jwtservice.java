package com.example.easycare.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    // Secret key used for signing the JWT
    @Value("${jwt.secret}")
    private String secret;

    // JWT expiration time in milliseconds
    @Value("${jwt.expiration}")
    private long jwtExpirationMs;

    // Generate JWT token using user ID and role
    public String generateToken(Long userId, String role) {
        return Jwts.builder()
                .setSubject(String.valueOf(userId))  // store user ID as subject
                .claim("role", role)                  // add user role as a claim
                .setIssuedAt(new Date())              // current timestamp
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs)) // set expiration
                .signWith(SignatureAlgorithm.HS512, secret) // sign token with HS512 algorithm
                .compact();
    }

    // Validate JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract user ID from JWT token
    public String extractUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // Extract role from JWT token (optional utility method)
    public String extractUserRole(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.get("role", String.class);
    }
}
