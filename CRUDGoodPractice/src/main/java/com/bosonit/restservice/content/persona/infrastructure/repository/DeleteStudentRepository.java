package com.bosonit.restservice.content.persona.infrastructure.repository;

import com.bosonit.restservice.content.persona.infrastructure.repository.jpa.StudentRepositoryJpa;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.DeleteStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeleteStudentRepository implements DeleteStudentPort {

    private StudentRepositoryJpa studentRepositoryJpa;

    @Override
    public void delete(String id) throws Exception {
        studentRepositoryJpa.deleteById(id);
    }

    @Override
    public void delete() throws Exception {
        studentRepositoryJpa.deleteAll();
    }
}
