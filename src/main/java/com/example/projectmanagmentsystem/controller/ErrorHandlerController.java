package com.example.projectmanagmentsystem.controller;

import com.example.projectmanagmentsystem.dto.InputValidationResponseDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InputValidationResponseDTO> handleInputError(MethodArgumentNotValidException ex) {

        var responseBody = ex.getFieldErrors().stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(
                                DefaultMessageSourceResolvable::getDefaultMessage,
                                Collectors.toList()
                        )
                ));

        InputValidationResponseDTO response = InputValidationResponseDTO.builder()
                .status(HttpStatus.BAD_REQUEST)
                .errors(responseBody)
                .build();


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);

    }
}
