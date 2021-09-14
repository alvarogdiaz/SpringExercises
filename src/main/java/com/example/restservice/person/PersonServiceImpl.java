package com.example.restservice.person;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private static Map<Integer, Person> people = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void createPerson(String name, String city, int age) {
        int id = counter.incrementAndGet();
        people.put(id, new Person(id, name, city, age));
    }

    @Override
    public void createPerson(Person p) {
        int aux = counter.incrementAndGet();
        p.setId(aux);
        people.put(aux, p);
    }

    @Override
    public Boolean existsPerson(int id) {
        return people.containsKey(id);
    }

    @Override
    public Person getPerson(int id) {
        return people.get(id);
    }

    @Override
    public List<Person> getPersonByName(String name) {
        return people.values().stream()
            .filter(s -> s.getName().equals(name))
            .collect(Collectors.toList());
    }

    @Override
    public Person updatePerson(int id, String name, String city, int age) {
        Person p = people.get(id);

        if (name != null) {
            p.setName(name);
        }
        if (city != null) {
            p.setCity(city);
        }
        if (age >= 0) {
            p.setAge(age);
        }

        people.replace(id, p);
        return p;
    }

    @Override
    public void deletePerson(int id) {
        people.remove(id);
    }

    @Override
    public Collection<Person> getPeople() {
        return people.values();
    }
}
