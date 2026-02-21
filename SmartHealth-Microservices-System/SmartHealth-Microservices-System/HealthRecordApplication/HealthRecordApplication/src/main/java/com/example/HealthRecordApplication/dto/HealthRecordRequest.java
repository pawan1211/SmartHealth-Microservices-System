package com.example.HealthRecordApplication.dto;



import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthRecordRequest {

    @Positive
    private int heartRate;

    @NotBlank
    private String bloodPressure;

    @Positive
    private double temperature;
}