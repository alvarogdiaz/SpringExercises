package com.bosonit.restservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:miconfiguracion.properties")
public class MiConfig {

    @Autowired
    private ApplicationArguments applicationArguments;

    @Bean
    public CommandLineRunner printParams(@Value("${valor1}") String v1,
                                         @Value("${valor2}") String v2) {
        return p -> {
            for(String s : p) {
                System.out.println("ARGS: " + s + "\n");
            }
            System.out.println("Val1: " + v1 + "\nVal2: " + v2);
        };
    }

    @Bean(name = "getParams")
    public String getParams(@Value("${valor1}") String v1,
                            @Value("${valor2}") String v2) {
        String g = "Val1: " + v1 + "\nVal2: " + v2 + "\n";
        for (String s : applicationArguments.getSourceArgs()) {
            g = g.concat("Args: " + s + "\n");
        }
        return g;
    }
}


