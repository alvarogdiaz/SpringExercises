package com.bosonit.restservice.content.persona.infrastructure.repository.port;

import com.bosonit.restservice.content.persona.domain.Student;

import java.util.List;

public interface FindStudentPort {
    List<Student> findAll() throws Exception;
    Student findById(String id) throws Exception;
    //List<Student> findByIdOfProfesor(String id) throws Exception;
    List<Student> findByBranch(String branch) throws Exception;
}
