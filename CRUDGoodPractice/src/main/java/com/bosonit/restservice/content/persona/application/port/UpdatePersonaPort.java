package com.bosonit.restservice.content.persona.application.port;

import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;

public interface UpdatePersonaPort {
    Persona update(int id, SavePersona savePersona) throws Exception;
}
