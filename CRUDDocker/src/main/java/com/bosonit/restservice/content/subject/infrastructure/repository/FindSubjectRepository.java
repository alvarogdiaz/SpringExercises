package com.bosonit.restservice.content.subject.infrastructure.repository;

import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.SubjectJpa;
import com.bosonit.restservice.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.FindSubjectPort;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FindSubjectRepository implements FindSubjectPort {

    private SubjectRepositoryJpa subjectRepositoryJpa;

    @Override
    public List<Subject> findAll() throws Exception {
        return subjectRepositoryJpa.findAll().stream()
                .map(Subject::new)
                .collect(Collectors.toList());
    }

    @Override
    public Subject findById(int id) throws Exception {
        SubjectJpa p = subjectRepositoryJpa.findById(id).orElseThrow(() ->
            new NotFoundException("Subject with id " + id + " not found"));

        return new Subject(p);
    }

    @Override
    public List<Subject> findBySubject(String subject) throws Exception {
        return subjectRepositoryJpa.findAllByAsignatura(subject).stream()
                .map(Subject::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Subject> findByStudentsId(int id) throws Exception {
        return subjectRepositoryJpa.findAllByStudentsId(id).stream()
                .map(Subject::new)
                .collect(Collectors.toList());
    }
}
