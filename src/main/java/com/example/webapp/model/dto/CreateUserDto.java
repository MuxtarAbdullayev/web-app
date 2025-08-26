package com.example.webapp.model.dto;

import com.example.webapp.validation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

    @NotBlank(message = "{web-app.constraint.username.notblank}")
    @Size(min = 3, max = 255)
    private String username;

    @Email
    @NotBlank
    //@UniqueEmail
    private String email;

    @NotBlank(message = "Şifrə boş ola bilməz")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
            message = "{web-app.constraint.password.pattern}"
    )
    private String password;
}
