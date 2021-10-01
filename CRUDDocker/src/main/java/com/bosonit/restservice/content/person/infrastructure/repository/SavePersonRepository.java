package com.bosonit.restservice.content.person.infrastructure.repository;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.PersonJpa;
import com.bosonit.restservice.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import com.bosonit.restservice.content.person.infrastructure.repository.port.SavePersonPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SavePersonRepository implements SavePersonPort {

    private PersonRepositoryJpa personRepositoryJpa;

    @Override
    public Person save(Person person) throws Exception {
        PersonJpa personJpa = new PersonJpa(person);
        personRepositoryJpa.save(personJpa);
        return new Person(personJpa);
    }
}
