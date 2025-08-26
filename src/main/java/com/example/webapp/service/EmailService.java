package com.example.webapp.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    JavaMailSenderImpl mailSender;

    public EmailService() {
        this.initialize();
    }

    public void initialize() {
        this.mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.ethereal.email");
        mailSender.setPort(587);
        mailSender.setUsername("lance.trantow@ethereal.email");
        mailSender.setPassword("EU7JqDp3v4fqZb7vWB");

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");
    }

    public void sendActivationEmail(String email, String activationToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@my-app.com");
        message.setTo(email);
        message.setSubject("Account activation");
        message.setText(activationToken);
        this.mailSender.send(message);
    }
}
