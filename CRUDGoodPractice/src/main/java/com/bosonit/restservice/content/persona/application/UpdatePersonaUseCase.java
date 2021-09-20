package com.bosonit.restservice.content.persona.application;

import com.bosonit.restservice.content.persona.application.port.UpdatePersonaPort;
import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.FindPersonaPort;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.SavePersonaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdatePersonaUseCase implements UpdatePersonaPort {

    private SavePersonaPort savePersonaPort;
    private FindPersonaPort findPersonaPort;

    @Override
    public Persona update(int id, SavePersona savePersona) throws Exception {
        Persona persona = findPersonaPort.findById(id);
        persona.update(savePersona);
        return savePersonaPort.save(persona);
    }
}
