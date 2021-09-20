package com.bosonit.restservice.content.persona.infrastructure.repository.port;

import com.bosonit.restservice.content.persona.domain.Persona;

import java.util.List;

public interface FindPersonaPort {
    List<Persona> findAll() throws Exception;
    Persona findById(int id) throws Exception;
    List<Persona> findByName(String name) throws Exception;
    List<Persona> findByUser(String user) throws Exception;

}
