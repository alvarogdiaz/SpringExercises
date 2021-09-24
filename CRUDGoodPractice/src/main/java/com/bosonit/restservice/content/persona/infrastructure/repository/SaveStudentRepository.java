package com.bosonit.restservice.content.persona.infrastructure.repository;

import com.bosonit.restservice.content.persona.domain.Student;
import com.bosonit.restservice.content.persona.domain.StudentJpa;
import com.bosonit.restservice.content.persona.infrastructure.repository.jpa.StudentRepositoryJpa;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.SaveStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveStudentRepository implements SaveStudentPort {

    private StudentRepositoryJpa studentRepositoryJpa;

    @Override
    public Student save(Student student) throws Exception {
        StudentJpa studentJpa = new StudentJpa(student);
        studentRepositoryJpa.save(studentJpa);
        return new Student(studentJpa);
    }
}
