package com.bosonit.restservice.content.student.infrastructure.repository.port;

import com.bosonit.restservice.content.student.domain.Student;

import java.util.List;

public interface FindStudentPort {
    List<Student> findAll() throws Exception;
    Student findById(int id) throws Exception;
    List<Student> findBySubjectId(int id) throws Exception;
    List<Student> findByBranch(String branch) throws Exception;
    List<Student> findByTeacherId(int id) throws Exception;
}
