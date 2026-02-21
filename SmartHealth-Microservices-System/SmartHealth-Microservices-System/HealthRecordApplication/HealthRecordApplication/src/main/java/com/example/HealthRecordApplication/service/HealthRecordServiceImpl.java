package com.example.HealthRecordApplication.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.HealthRecordApplication.dto.HealthRecordRequest;
import com.example.HealthRecordApplication.dto.HealthRecordResponse;
import com.example.HealthRecordApplication.entity.HealthRecord;
import com.example.HealthRecordApplication.repository.HealthRecordRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HealthRecordServiceImpl
        implements HealthRecordService {

    private final HealthRecordRepository repository;
    private final RestTemplate restTemplate;

    private static final String PATIENT_SERVICE_URL =
            "http://patient-service/api/patients/";

    @Override
    @CircuitBreaker(name = "patientService",
            fallbackMethod = "fallback")
    public HealthRecordResponse create(
            Long patientId,
            HealthRecordRequest request) {

        log.info("Validating patient {}", patientId);

        // 🔥 Validate via Feign
       // feignClient.getPatient(patientId);
        
        restTemplate.getForObject(
                PATIENT_SERVICE_URL + patientId,
                Object.class
        );

        HealthRecord record = new HealthRecord();
        record.setPatientId(patientId);
        record.setHeartRate(request.getHeartRate());
        record.setBloodPressure(request.getBloodPressure());
        record.setTemperature(request.getTemperature());
        record.setRecordedAt(LocalDateTime.now());

        HealthRecord saved = repository.save(record);

        return mapToResponse(saved);
    }

    @Override
    public List<HealthRecordResponse> getByPatient(Long patientId) {

        return repository.findByPatientId(patientId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // 🔥 Circuit breaker fallback
    public HealthRecordResponse fallback(
            Long patientId,
            HealthRecordRequest request,
            Exception ex) {

        log.error("Patient Service unavailable");
        throw new RuntimeException(
                "Patient service unavailable. Try later.");
    }

    private HealthRecordResponse mapToResponse(
            HealthRecord record) {

        HealthRecordResponse response =
                new HealthRecordResponse();

        response.setId(record.getId());
        response.setPatientId(record.getPatientId());
        response.setHeartRate(record.getHeartRate());
        response.setBloodPressure(record.getBloodPressure());
        response.setTemperature(record.getTemperature());
        response.setRecordedAt(record.getRecordedAt());

        return response;
    }
}