package com.example.webapp.validation;

import com.example.webapp.model.entity.User;
import com.example.webapp.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private final UserRepository userRepository;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User dbUser = userRepository.findByEmail(value);
        return dbUser == null;
    }
}
