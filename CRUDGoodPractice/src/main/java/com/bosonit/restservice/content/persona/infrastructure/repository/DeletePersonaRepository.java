package com.bosonit.restservice.content.persona.infrastructure.repository;

import com.bosonit.restservice.content.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.DeletePersonaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeletePersonaRepository implements DeletePersonaPort {

    private PersonaRepositoryJpa personaRepositoryJpa;

    @Override
    public void delete(int id) throws Exception {
        personaRepositoryJpa.deleteById(id);
    }

    @Override
    public void delete() throws Exception {
        personaRepositoryJpa.deleteAll();
    }
}
