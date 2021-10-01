package com.bosonit.restservice.content.teacher.infrastructure.repository;

import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.domain.TeacherJpa;
import com.bosonit.restservice.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.SaveTeacherPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveTeacherRepository implements SaveTeacherPort {

    private TeacherRepositoryJpa teacherRepositoryJpa;

    @Override
    public Teacher save(Teacher teacher) throws Exception {
        TeacherJpa teacherJpa = new TeacherJpa(teacher);
        teacherRepositoryJpa.save(teacherJpa);
        return new Teacher(teacherJpa);
    }
}
