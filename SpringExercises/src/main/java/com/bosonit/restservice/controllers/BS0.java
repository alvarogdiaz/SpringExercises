package com.bosonit.restservice.controllers;

import com.bosonit.restservice.domain.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class BS0 {

    @GetMapping("/hellouser/{nombre}")
    public String hello(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @PostMapping("/useradd")
    public Person person(@RequestParam(value = "name") String name,
                         @RequestParam(value = "city") String city,
                         @RequestParam(value = "age") int age) {
        return new Person(name, city, age + 1, 0);
    }
}
