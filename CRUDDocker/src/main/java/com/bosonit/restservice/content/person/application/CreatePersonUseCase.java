package com.bosonit.restservice.content.person.application;

import com.bosonit.restservice.content.person.application.port.CreatePersonPort;
import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import com.bosonit.restservice.content.person.infrastructure.repository.port.SavePersonPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreatePersonUseCase implements CreatePersonPort {

    private SavePersonPort savePersonPort;

    @Override
    public Person create(SavePerson savePersona) throws Exception {
        Person person = new Person();
        person.update(savePersona);
        return savePersonPort.save(person);
    }
}
