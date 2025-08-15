package com.example.webapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Proyektin API Dokumentasiyasi",
                version = "1.0",
                description = "Spring Boot proyekti ucun Swagger interface-i"
        )
)
@Configuration
public class OpenApiConfig {
}
