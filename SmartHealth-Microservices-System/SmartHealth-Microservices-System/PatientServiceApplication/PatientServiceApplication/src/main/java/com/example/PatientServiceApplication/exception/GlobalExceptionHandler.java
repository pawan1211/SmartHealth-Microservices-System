package com.example.PatientServiceApplication.exception;



import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(
            ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(
                        404,
                        ex.getMessage(),
                        LocalDateTime.now()));
    }
}