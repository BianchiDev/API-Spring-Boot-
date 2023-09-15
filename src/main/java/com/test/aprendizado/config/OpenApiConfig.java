package com.test.aprendizado.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
     info = @Info(
        title = "Teste Produto",
        description = "Documentao CRUD de produto",
        summary = "A API de Produto é um esboço de desenvolvimento em monolítico",
        termsOfService = "Bianch & Lamare",
        contact = @Contact(
            name = "Felipe Bianchi",
            email = "ifpebinachi@gmail.com"
        ),
        license = @License(
            name = "Sua licença"
        ), 
        version = "1.0.0"
     ),
     servers = {
        @Server(
            description = "Dev",
            url = "http://http://localhost:3000/"
        ),
        @Server(
            description = "test",
            url = "http://http://localhost:8080/"
        ),
        @Server(
            description = "DevOps",
            url = "http://http://localhost:3001/"
        )
     }
)
public class OpenApiConfig {
    
}
