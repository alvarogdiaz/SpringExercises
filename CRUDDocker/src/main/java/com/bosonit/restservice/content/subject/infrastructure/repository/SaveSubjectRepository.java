package com.bosonit.restservice.content.subject.infrastructure.repository;

import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.SubjectJpa;
import com.bosonit.restservice.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.SaveSubjectPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveSubjectRepository implements SaveSubjectPort {

    private SubjectRepositoryJpa subjectRepositoryJpa;

    @Override
    public Subject save(Subject subject) throws Exception {
        SubjectJpa subjectJpa = new SubjectJpa(subject);
        subjectRepositoryJpa.save(subjectJpa);
        return new Subject(subjectJpa);
    }
}
