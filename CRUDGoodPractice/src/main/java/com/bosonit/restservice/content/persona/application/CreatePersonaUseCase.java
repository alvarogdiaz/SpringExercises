package com.bosonit.restservice.content.persona.application;

import com.bosonit.restservice.content.persona.application.port.CreatePersonaPort;
import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.SavePersonaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class CreatePersonaUseCase implements CreatePersonaPort {

    private SavePersonaPort savePersonaPort;

    @Override
    public Persona create(SavePersona savePersona) throws Exception {
        Persona persona = new Persona();
        savePersona.setCreated_date(new Date());
        persona.update(savePersona);
        return savePersonaPort.save(persona);
    }
}
