package com.bosonit.restservice.content.person.infrastructure.repository.jpa;

import com.bosonit.restservice.content.person.domain.PersonJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PersonRepositoryJpa extends JpaRepository<PersonJpa, Integer> {

    List<PersonJpa> findAllByName(String name);
    List<PersonJpa> findAllByUsername(String user);

}
