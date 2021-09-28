package com.bosonit.restservice.content.teacher.infrastructure.repository;

import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.domain.TeacherJpa;
import com.bosonit.restservice.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.FindTeacherPort;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FindTeacherRepository implements FindTeacherPort {

    private TeacherRepositoryJpa teacherRepositoryJpa;

    @Override
    public List<Teacher> findAll() throws Exception {
        return teacherRepositoryJpa.findAll().stream()
                .map(Teacher::new)
                .collect(Collectors.toList());
    }

    @Override
        public Teacher findById(String id) throws Exception {
        TeacherJpa p = teacherRepositoryJpa.findById(id).orElseThrow(() ->
            new NotFoundException("Teacher with id " + id + " not found"));

        return new Teacher(p);
    }

    @Override
    public List<Teacher> findByBranch(String branch) throws Exception {
        return teacherRepositoryJpa.findAllByBranch(branch).stream()
                .map(Teacher::new)
                .collect(Collectors.toList());
    }
}
