package com.bosonit.restservice.BS3;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class First {

    @PostConstruct
    private void init() {
        System.out.println("Hola desde la clase inicial");
    }
}
