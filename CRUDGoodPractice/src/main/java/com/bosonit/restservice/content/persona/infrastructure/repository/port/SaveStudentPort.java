package com.bosonit.restservice.content.persona.infrastructure.repository.port;

import com.bosonit.restservice.content.persona.domain.Student;

public interface SaveStudentPort {
    Student save(Student student) throws Exception;
}
