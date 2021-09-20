package com.bosonit.restservice.content.persona.infrastructure.repository.port;

import com.bosonit.restservice.content.persona.domain.Persona;

public interface DeletePersonaPort {
    Persona delete(Persona persona) throws Exception;
    void delete(int id) throws Exception;
    void delete() throws Exception;
}
