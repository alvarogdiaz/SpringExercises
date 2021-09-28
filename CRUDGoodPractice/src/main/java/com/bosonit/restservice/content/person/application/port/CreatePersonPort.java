package com.bosonit.restservice.content.person.application.port;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;

public interface CreatePersonPort {
    Person create(SavePerson savePersona) throws Exception;
}
