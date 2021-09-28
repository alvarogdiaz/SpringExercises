package com.bosonit.restservice.content.student.infrastructure.repository.port;

import com.bosonit.restservice.content.student.domain.Student;

import java.util.List;

public interface FindStudentPort {
    List<Student> findAll() throws Exception;
    Student findById(String id) throws Exception;
    List<Student> findBySubjectId(String id) throws Exception;
    List<Student> findByBranch(String branch) throws Exception;
    List<Student> findByTeacherId(String id) throws Exception;
}
