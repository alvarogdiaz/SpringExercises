package com.bosonit.restservice.content.student.infrastructure.repository;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.StudentJpa;
import com.bosonit.restservice.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import com.bosonit.restservice.content.student.infrastructure.repository.port.FindStudentPort;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FindStudentRepository implements FindStudentPort {

    private StudentRepositoryJpa studentRepositoryJpa;

    @Override
    public List<Student> findAll() throws Exception {
        return studentRepositoryJpa.findAll().stream()
                .map(Student::new)
                .collect(Collectors.toList());
    }

    @Override
        public Student findById(int id) throws Exception {
        StudentJpa p = studentRepositoryJpa.findById(id).orElseThrow(() ->
            new NotFoundException("Student with id " + id + " not found"));

        return new Student(p);
    }

    @Override
    public List<Student> findByBranch(String branch) throws Exception {
        return studentRepositoryJpa.findAllByBranch(branch).stream()
                .map(Student::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findByTeacherId(int id) throws Exception {
        return studentRepositoryJpa.findAllByTeacherId(id).stream()
                .map(Student::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findBySubjectId(int id) throws Exception {
        return studentRepositoryJpa.findAllBySubjectsId(id).stream()
                .map(Student::new)
                .collect(Collectors.toList());
    }
}
