package com.poyu.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components()
                .addSecuritySchemes("basicScheme", new SecurityScheme()
                .type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info().title("Custom API")
                .version("1.0"))
                .addTagsItem(new Tag().name("demo"));
    }

}