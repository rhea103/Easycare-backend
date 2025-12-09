package com.example.easycare.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

public class CloudDB {

    private String dbName;
    private double storageSize;
    private String encryptionKey;
}
