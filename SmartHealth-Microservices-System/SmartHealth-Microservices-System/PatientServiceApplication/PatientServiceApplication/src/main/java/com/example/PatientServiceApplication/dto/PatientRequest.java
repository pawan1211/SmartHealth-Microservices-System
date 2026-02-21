package com.example.PatientServiceApplication.dto;



import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequest {

    @NotBlank
    private String name;

    @Min(1)
    private int age;

    @Email
    @NotBlank
    private String email;
}