package com.bosonit.restservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private String name, city;
    private int age, id;

    public Person(Person p) {
        this.name = p.getName();
        this.city = p.getCity();
        this.age = p.getAge();
        this.id = p.getId();
    }
}
