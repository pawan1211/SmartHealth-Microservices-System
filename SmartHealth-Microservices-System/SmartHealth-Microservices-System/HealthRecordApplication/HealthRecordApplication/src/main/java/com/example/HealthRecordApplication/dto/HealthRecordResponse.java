package com.example.HealthRecordApplication.dto;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HealthRecordResponse {

    private Long id;
    private Long patientId;
    private int heartRate;
    private String bloodPressure;
    private double temperature;
    private LocalDateTime recordedAt;
}