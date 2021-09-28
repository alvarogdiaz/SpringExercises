package com.bosonit.restservice.content.subject.infrastructure.repository;

import com.bosonit.restservice.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.DeleteSubjectPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeleteSubjectRepository implements DeleteSubjectPort {

    private SubjectRepositoryJpa subjectRepositoryJpa;

    @Override
    public void delete(String id) throws Exception {
        subjectRepositoryJpa.deleteById(id);
    }

    @Override
    public void delete() throws Exception {
        subjectRepositoryJpa.deleteAll();
    }
}
