package com.spring.api.exception;

import java.time.Instant;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<Map<String, Object>> handleBadRequest(BadRequestException error) {
    return ResponseEntity.status(400).body(Map.of(
        "status", 400,
        "error", "Bad Request",
        "message", error.getMessage(),
        "timestamp", Instant.now().toString()));
  }
}
