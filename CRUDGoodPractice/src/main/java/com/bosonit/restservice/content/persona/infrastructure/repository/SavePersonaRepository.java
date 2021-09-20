package com.bosonit.restservice.content.persona.infrastructure.repository;

import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.PersonaJpa;
import com.bosonit.restservice.content.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.SavePersonaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SavePersonaRepository implements SavePersonaPort {

    private PersonaRepositoryJpa personaRepositoryJpa;

    @Override
    public Persona save(Persona persona) throws Exception {
        PersonaJpa personaJpa = new PersonaJpa(persona);
        personaRepositoryJpa.save(personaJpa);
        return new Persona(personaJpa);
    }
}
