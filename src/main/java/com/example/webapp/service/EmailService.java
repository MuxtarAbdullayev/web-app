package com.example.webapp.service;

import com.example.webapp.config.WebAppProperties;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmailService {

    JavaMailSenderImpl mailSender;
    private final WebAppProperties webAppProperties;

    @PostConstruct
    public void initialize() {
        this.mailSender = new JavaMailSenderImpl();
        mailSender.setHost(webAppProperties.getEmail().host());
        mailSender.setPort(webAppProperties.getEmail().port());
        mailSender.setUsername(webAppProperties.getEmail().username());
        mailSender.setPassword(webAppProperties.getEmail().password());

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");
    }

    public void sendActivationEmail(String email, String activationToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(webAppProperties.getEmail().from());
        message.setTo(email);
        message.setSubject("Account activation");
        message.setText(activationToken);
        this.mailSender.send(message);
    }
}
