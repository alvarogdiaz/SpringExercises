package com.bosonit.restservice.service;

import com.bosonit.restservice.domain.Person;

import java.util.Collection;
import java.util.List;

public interface IPersonService {
    void createPerson(String name, String city, int age);
    void createPerson(Person p);
    Boolean existsPerson(int id);
    Person getPerson(int id);
    List<Person> getPersonByName(String name);
    Person updatePerson(int id, String name, String city, int age);
    void deletePerson(int id);
    Collection<Person> getPeople();
}
