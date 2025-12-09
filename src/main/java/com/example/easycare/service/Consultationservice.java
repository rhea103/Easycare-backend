package com.example.easycare.service;

import com.example.easycare.model.Consultation;
import com.example.easycare.repository.Consultationrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Consultationservice {

    @Autowired
    private Consultationrepository consultationRepo;

    public Consultation scheduleConsultation(Consultation c) {
        c.setConsultationID(UUID.randomUUID().toString());
        c.setStatus("Scheduled");
        return consultationRepo.save(c);
    }

    public String startConsultation(String id) {
        Consultation c = consultationRepo.findById(id).orElse(null);
        if (c == null) return "Consultation not found";

        c.setStatus("In Progress");
        consultationRepo.save(c);
        return "Consultation started";
    }

    public String endConsultation(String id) {
        Consultation c = consultationRepo.findById(id).orElse(null);
        if (c == null) return "Consultation not found";

        c.setStatus("Completed");
        consultationRepo.save(c);
        return "Consultation ended";
    }
}
