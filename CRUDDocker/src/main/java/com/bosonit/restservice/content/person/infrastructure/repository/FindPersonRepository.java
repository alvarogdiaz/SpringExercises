package com.bosonit.restservice.content.person.infrastructure.repository;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.PersonJpa;
import com.bosonit.restservice.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FindPersonRepository implements FindPersonPort {

    private PersonRepositoryJpa personRepositoryJpa;

    @Override
    public List<Person> findAll() throws Exception {
        return personRepositoryJpa.findAll().stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    @Override
    public Person findById(int id) throws Exception {
        PersonJpa p = personRepositoryJpa.findById(id).orElseThrow(() ->
            new NotFoundException("Person with id " + id + " not found"));

        return new Person(p);
    }

    @Override
    public List<Person> findByName(String name) throws Exception {
        return personRepositoryJpa.findAllByName(name).stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findByUser(String user) throws Exception {
        return personRepositoryJpa.findAllByUsername(user).stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }
}
