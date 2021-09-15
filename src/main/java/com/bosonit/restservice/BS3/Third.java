package com.bosonit.restservice.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class Third {

    @Bean
    public CommandLineRunner getThird() {
        return p -> {
            System.out.println("Hola desde clase terciaria");
            for(String s : p) {
                System.out.println("ARGS: " + s);
            }
        };
    }
}
