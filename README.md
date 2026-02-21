# SmartHealth-Microservices-System


🏥 SmartHealth Microservices System

A production-style microservices backend built using:

✅ Spring Boot 4


✅ Spring Cloud


✅ Eureka Service Discovery


✅ API Gateway


✅ RestTemplate (Service-to-Service Communication)


✅ Resilience4j Circuit Breaker


✅ SLF4J Logging


✅ PostgreSQL


✅ Spring Boot Actuator

📌 Project Overview

SmartHealth is a distributed healthcare system that manages:

Patient registration

Patient health records

Inter-service communication

Fault tolerance

Centralized routing

This project demonstrates real-world microservice resilience and communication patterns.

🏗 Architecture
Client
  
   ↓
   
API Gateway (8086)
  
   ↓
   
   
HealthRecord Service (8082)
  
   ↓ (RestTemplate Call)
   
Patient Service (8081)
 
   ↓
   
PostgreSQL


Eureka Server (8761)

🔄 Service Communication

🔹 RestTemplate

HealthRecord Service calls Patient Service using:

ResponseEntity<PatientResponse> response =
    restTemplate.getForEntity(
        "http://patient-service/api/patients/" + id,
        PatientResponse.class);

Uses service name (patient-service)

Resolved via Eureka

Load balanced automatically

🛡 Circuit Breaker (Resilience4j)

If Patient Service is:

Down

Slow

Failing repeatedly

Circuit Breaker will:

Open circuit

Stop further calls

Trigger fallback method

Example:

@CircuitBreaker(name = "patientService",
                fallbackMethod = "fallback")
public HealthRecordResponse createRecord(...) {
    ...
}

Fallback method:

public HealthRecordResponse fallback(..., Exception ex) {
    throw new RuntimeException("Patient Service unavailable");
}
🛠 Technologies Used

Component	Technology

Backend	Spring Boot 4

Service Discovery	Eureka

Gateway	Spring Cloud Gateway

Communication	RestTemplate

Resilience	Resilience4j

Logging	SLF4J

Database	PostgreSQL

Monitoring	Spring Actuator

🚀 How to Run

1️⃣ Create Databases
CREATE DATABASE patientdb;
CREATE DATABASE healthdb;

2️⃣ Start Services (Order Matters)

Start Eureka Server

Start Patient Service

Start HealthRecord Service

Start API Gateway

🌐 API Testing (Postman)

Base URL:

http://localhost:8086

🔹 Create Patient

POST

http://localhost:8086/api/patients

Body:

{
  "name": "Pawan",
  "age": 28,
  "email": "pawan@test.com"
}
🔹 Create Health Record

POST

http://localhost:8086/api/records/1

Body:

{
  "heartRate": 80,
  "bloodPressure": "120/80",
  "temperature": 98.7
}
🔥 Failure Testing
Circuit Breaker Test

Stop Patient Service

Call HealthRecord API

Expected:

Fallback executed

Error returned

Circuit opens

📊 Monitoring

Health endpoints:

http://localhost:8081/actuator/health
http://localhost:8082/actuator/health
📌 What This Project Demonstrates

Microservice isolation

Service discovery

Gateway routing

Inter-service REST communication

Fault tolerance with circuit breaker

Production logging using SLF4J

Clean layered architecture

🧠 Why Circuit Breaker Is Important

Without Circuit Breaker:

Patient Service Down

↓

HealthRecord waits

↓

Thread pool exhausted

↓

System crash

With Circuit Breaker:

Patient Service Down

↓

Circuit opens

↓

Fallback response

↓

System stays stable


Deploy to Kubernetes

👨‍💻 Author

SmartHealth Microservices

Built for real-world Spring Cloud architecture practice.
