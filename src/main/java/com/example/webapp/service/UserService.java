package com.example.webapp.service;

import com.example.webapp.exception.NotUniqueEmailException;
import com.example.webapp.model.dto.CreateUserDto;
import com.example.webapp.model.entity.User;
import com.example.webapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void save(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new NotUniqueEmailException(ex.getMessage());
        }
    }

    public void createUser(CreateUserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
    }
}
