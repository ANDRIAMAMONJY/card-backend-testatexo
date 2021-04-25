package com.cardgenerator.game.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GameExceptionHandler {

    @ExceptionHandler(value = {
        IllegalStateException.class,
        IllegalArgumentException.class
    })
    public ResponseEntity<ErrorResponse> handleCardException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getClass().getSimpleName(), e.getMessage()));
    }

    public static class ErrorResponse {
        private final String code;
        private final String message;
        public ErrorResponse(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
