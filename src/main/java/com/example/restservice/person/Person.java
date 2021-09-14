package com.example.restservice.person;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name, city;
    private int age, id;

    public Person() { }

    public Person(int id, String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.id = id;
    }

    public Person(Person p) {
        this.name = p.getName();
        this.city = p.getCity();
        this.age = p.getAge();
        this.id = p.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
