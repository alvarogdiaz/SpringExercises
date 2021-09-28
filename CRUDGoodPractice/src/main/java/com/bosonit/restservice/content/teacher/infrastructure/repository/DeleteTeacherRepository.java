package com.bosonit.restservice.content.teacher.infrastructure.repository;

import com.bosonit.restservice.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.DeleteTeacherPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeleteTeacherRepository implements DeleteTeacherPort {

    private TeacherRepositoryJpa teacherRepositoryJpa;

    @Override
    public void delete(String id) throws Exception {
        teacherRepositoryJpa.deleteById(id);
    }

    @Override
    public void delete() throws Exception {
        teacherRepositoryJpa.deleteAll();
    }
}
