package com.bank.error;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle validation exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        CustomErrorResponse errorResponse = new CustomErrorResponse(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Validation Failed",
            errors.toString(),
            request.getDescription(false)
        );
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle custom exceptions
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomException(CustomException ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
            LocalDateTime.now(),
           HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Custom Error",
            ex.getMessage(),
            request.getDescription(false)
        );

        return new ResponseEntity<>(errorResponse, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleGeneralException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
            LocalDateTime.now(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal Server Error",
            ex.getMessage(),
            request.getDescription(false)
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
