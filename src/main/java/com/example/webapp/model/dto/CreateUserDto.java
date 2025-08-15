package com.example.webapp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    @NotBlank(message = "Ad bos ola bilmez")
    private String username;

    @Email(message = "Email dogru deyil")
    private String email;

    @Size(min = 4, message = "Sifre en az 4 simvol olmalidir")
    private String password;
}
