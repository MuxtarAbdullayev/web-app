package com.example.webapp.controller;

import com.example.webapp.model.entity.User;
import com.example.webapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @PostMapping("/api/v1/users")
    void createUser(@RequestBody User user) {
        userService.save(user);
    }
}
