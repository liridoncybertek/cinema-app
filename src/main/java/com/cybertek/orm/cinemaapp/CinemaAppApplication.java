package com.cybertek.orm.cinemaapp;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CinemaAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(CinemaAppApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                                .title("Cinema application")
                                .version("v1")
                                .description("Selling online tickets for cinemas")
                    );
    }
}
