package com.bosonit.restservice.content.persona.infrastructure.repository.port;

import com.bosonit.restservice.content.persona.domain.Persona;

public interface DeletePersonaPort {
    void delete(int id) throws Exception;
    void delete() throws Exception;
}
