package com.bosonit.restservice.content.person.infrastructure.repository;

import com.bosonit.restservice.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import com.bosonit.restservice.content.person.infrastructure.repository.port.DeletePersonPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeletePersonRepository implements DeletePersonPort {

    private PersonRepositoryJpa personRepositoryJpa;

    @Override
    public void delete(int id) throws Exception {
        personRepositoryJpa.deleteById(id);
    }

    @Override
    public void delete() throws Exception {
        personRepositoryJpa.deleteAll();
    }
}
