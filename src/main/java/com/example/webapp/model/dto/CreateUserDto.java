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

    @NotBlank(message = "İstifadəçi adı boş ola bilməz")
    @Size(min = 3, max = 255, message = "İstifadəçi adı 3-255 simvol arasında olmalıdır")
    private String username;

    @NotBlank(message = "Email boş ola bilməz")
    @Email(message = "Email düzgün formatda deyil")
    @UniqueEmail
    private String email;

    @NotBlank(message = "Şifrə boş ola bilməz")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
            message = "Şifrə ən az 8 simvol, böyük və kiçik hərf, rəqəm və xüsusi simvol olmalidir!"
    )
    private String password;
}
