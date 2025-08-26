package com.example.webapp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "web-app")
@Configuration
@Getter
@Setter
public class WebAppProperties {

    private Email email;

    public record Email(
            String username,
            String password,
            String host,
            int port,
            String from
    ) {
    }
}
