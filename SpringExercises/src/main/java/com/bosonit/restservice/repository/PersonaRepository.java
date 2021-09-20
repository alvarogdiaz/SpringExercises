package com.bosonit.restservice.repository;

import com.bosonit.restservice.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    List<Persona> findAllByName(String name);

}
