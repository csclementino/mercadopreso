package com.mercadopreso.payment.gateways;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            erros.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleJsonParseException(
            HttpMessageNotReadableException ex) {

        Map<String, String> erros = new HashMap<>();

        String message = ex.getMostSpecificCause().getMessage();

        if (message != null && message.contains("Gateway")) {
            erros.put("gateway", "Gateway inválido");
        } else if (message != null && message.contains("Type")) {
            erros.put("type", "Tipo inválido");
        } else {
            erros.put("error", "JSON inválido");
        }

        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }
}
