package br.com.flixy.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI(){
        Contact contact = new Contact();
        contact.name("Thiago");
        contact.email("alms.thiago@gmail.com");

        Info info = new Info();
        info.title("Flixy");
        info.version("v1");
        info.description("Aplicacao para gerenciamento de catalogo de filmes");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
