package com.example.HealthRecordApplication.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "health_records",
       indexes = @Index(name = "idx_patient_id", columnList = "patientId"))
@Getter
@Setter
public class HealthRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private int heartRate;
    private String bloodPressure;
    private double temperature;

    private LocalDateTime recordedAt;
}