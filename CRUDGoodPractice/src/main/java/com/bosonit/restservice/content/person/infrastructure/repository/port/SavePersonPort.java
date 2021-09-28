package com.bosonit.restservice.content.person.infrastructure.repository.port;

import com.bosonit.restservice.content.person.domain.Person;

public interface SavePersonPort {
    Person save(Person person) throws Exception;
}
