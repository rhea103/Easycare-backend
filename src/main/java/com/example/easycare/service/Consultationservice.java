package com.example.easycare.service;

import com.example.easycare.dto.ConsultationRequestDTO;
import com.example.easycare.model.Consultation;
import com.example.easycare.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationserviceImpl implements Consultationservice {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public Consultation scheduleConsultation(ConsultationRequestDTO dto) {
        Consultation c = new Consultation();
        c.setPatientId(dto.getPatientId());
        c.setDoctorId(dto.getDoctorId());
        c.setDateTime(dto.getDateTime());
        c.setStatus("Scheduled");
        return consultationRepository.save(c);
    }

    @Override
    public String startConsultation(String id) {
        Consultation c = consultationRepository.findById(id).orElse(null);
        if (c == null) return "Consultation not found";
        c.setStatus("In Progress");
        consultationRepository.save(c);
        return "Consultation started";
    }

    @Override
    public String endConsultation(String id) {
        Consultation c = consultationRepository.findById(id).orElse(null);
        if (c == null) return "Consultation not found";
        c.setStatus("Completed");
        consultationRepository.save(c);
        return "Consultation ended";
    }
}
