package com.bosonit.restservice.content.persona.infrastructure.repository.jpa;

import com.bosonit.restservice.content.persona.domain.PersonaJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepositoryJpa extends JpaRepository<PersonaJpa, Integer> {

    List<PersonaJpa> findAllByName(String name);
    List<PersonaJpa> findAllByUser(String user);

}
