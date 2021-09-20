package com.bosonit.restservice.content.persona.infrastructure.repository;

import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.PersonaJpa;
import com.bosonit.restservice.content.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.DeletePersonaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeletePersonaRepository implements DeletePersonaPort {

    private PersonaRepositoryJpa personaRepositoryJpa;

    @Override
    public Persona delete(Persona persona) throws Exception {
        PersonaJpa personaJpa = new PersonaJpa(persona);
        personaRepositoryJpa.delete(personaJpa);
        return new Persona(personaJpa);
    }

    @Override
    public void delete(int id) throws Exception {
        personaRepositoryJpa.deleteById(id);
    }

    @Override
    public void delete() throws Exception {
        personaRepositoryJpa.deleteAll();
    }
}
