package com.example.webapp.controller;

import com.example.webapp.model.dto.CreateUserDto;
import com.example.webapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;
    public final MessageSource messageSource;

    @PostMapping("/api/v1/users")
    ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDto dto) {
        userService.createUser(dto);
        String message = messageSource.getMessage("web-app.create.user.success.message", null, LocaleContextHolder.getLocale());
        return ResponseEntity.ok(message);
    }
}
