package com.example.easycare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CloudDB {

    // Stores the name of the cloud database
    private String dbName;

    // Stores the size of the storage in GB
    private double storageSize;

    // Stores the encryption key used for securing the database
    private String encryptionKey;
}
