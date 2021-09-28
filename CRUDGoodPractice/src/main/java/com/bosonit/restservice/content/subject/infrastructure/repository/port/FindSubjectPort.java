package com.bosonit.restservice.content.subject.infrastructure.repository.port;

import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.SubjectJpa;

import java.util.List;

public interface FindSubjectPort {
    List<Subject> findAll() throws Exception;
    Subject findById(String id) throws Exception;
    List<Subject> findBySubject(String subject) throws Exception;
    List<Subject> findByStudentsId(String id) throws Exception;
}
