package com.bosonit.restservice.content.persona.infrastructure.repository.port;

import com.bosonit.restservice.content.persona.domain.Persona;

public interface SavePersonaPort {
    Persona save(Persona persona) throws Exception;
}
