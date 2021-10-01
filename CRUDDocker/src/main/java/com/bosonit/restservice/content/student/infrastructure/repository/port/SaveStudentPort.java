package com.bosonit.restservice.content.student.infrastructure.repository.port;

import com.bosonit.restservice.content.student.domain.Student;

public interface SaveStudentPort {
    Student save(Student student) throws Exception;
}
