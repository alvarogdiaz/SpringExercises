package com.bosonit.restservice.content.persona.infrastructure.repository;

import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.PersonaJpa;
import com.bosonit.restservice.content.persona.infrastructure.repository.jpa.PersonaRepositoryJpa;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.FindPersonaPort;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FindPersonaRepository implements FindPersonaPort {

    private PersonaRepositoryJpa personaRepositoryJpa;

    @Override
    public List<Persona> findAll() throws Exception {
        return personaRepositoryJpa.findAll().stream()
                .map(Persona::new)
                .collect(Collectors.toList());
    }

    @Override
    public Persona findById(int id) throws Exception {
        PersonaJpa p = personaRepositoryJpa.findById(id).orElseThrow(() ->
            new NotFoundException("Person with id " + id + " not found"));

        return new Persona(p);
    }

    @Override
    public List<Persona> findByName(String name) throws Exception {
        return personaRepositoryJpa.findAllByName(name).stream()
                .map(Persona::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Persona> findByUser(String user) throws Exception {
        return personaRepositoryJpa.findAllByUser(user).stream()
                .map(Persona::new)
                .collect(Collectors.toList());
    }
}
