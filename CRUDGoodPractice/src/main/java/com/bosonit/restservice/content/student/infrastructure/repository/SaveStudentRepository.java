package com.bosonit.restservice.content.student.infrastructure.repository;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.StudentJpa;
import com.bosonit.restservice.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import com.bosonit.restservice.content.student.infrastructure.repository.port.SaveStudentPort;
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
