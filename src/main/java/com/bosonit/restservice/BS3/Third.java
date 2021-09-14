package com.bosonit.restservice.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Third implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola desde clase terciaria");
        for(String s : args) {
            System.out.println("ARGS: " + s);
        }
    }
}
