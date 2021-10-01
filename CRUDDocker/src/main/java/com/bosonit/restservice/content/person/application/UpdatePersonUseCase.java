package com.bosonit.restservice.content.person.application;

import com.bosonit.restservice.content.person.application.port.UpdatePersonPort;
import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import com.bosonit.restservice.content.person.infrastructure.repository.port.SavePersonPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdatePersonUseCase implements UpdatePersonPort {

    private SavePersonPort savePersonPort;
    private FindPersonPort findPersonPort;

    @Override
    public Person update(int id, SavePerson savePersona) throws Exception {
        Person person = findPersonPort.findById(id);
        person.update(savePersona);
        return savePersonPort.save(person);
    }
}
