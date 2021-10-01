package com.bosonit.restservice.content.person.application.port;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;

public interface UpdatePersonPort {
    Person update(int id, SavePerson savePersona) throws Exception;
}
