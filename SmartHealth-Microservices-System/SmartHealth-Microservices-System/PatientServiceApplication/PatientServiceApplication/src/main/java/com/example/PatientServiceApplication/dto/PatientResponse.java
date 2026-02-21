package com.example.PatientServiceApplication.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientResponse {

    private Long id;
    private String name;
    private int age;
    private String email;
}