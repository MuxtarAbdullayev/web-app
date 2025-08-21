package com.example.webapp.controller;

import com.example.webapp.error.ApiError;
import com.example.webapp.exception.NotUniqueEmailException;
import com.example.webapp.model.dto.CreateUserDto;
import com.example.webapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @PostMapping("/api/v1/users")
    ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDto dto) {
        userService.createUser(dto);
        return ResponseEntity.ok("User is created.");
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleMethodArgNotValidEx(MethodArgumentNotValidException e) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/users");
        apiError.setMessage("Validation error");
        apiError.setStatus(400);
        Map<String, String> validationErrors = new HashMap<>();
        for (var fieldError : e.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        apiError.setValidationErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(NotUniqueEmailException.class)
    ResponseEntity<ApiError> handleNotUniqueEmail(NotUniqueEmailException e) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/users");
        apiError.setMessage("Validation error");
        apiError.setStatus(400);
        Map<String, String> validationErrors = new HashMap<>();
        validationErrors.put("email", "E-mail in use");
        apiError.setValidationErrors(validationErrors);

        return ResponseEntity.badRequest().body(apiError);
    }
}
