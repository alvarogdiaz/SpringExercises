package com.bosonit.restservice.content.student.infrastructure.repository;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import com.bosonit.restservice.content.student.infrastructure.repository.port.DeleteStudentPort;
import com.bosonit.restservice.content.student.infrastructure.repository.port.FindStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

@Repository
@AllArgsConstructor
public class DeleteStudentRepository implements DeleteStudentPort {

    private StudentRepositoryJpa studentRepositoryJpa;

    @Override
    public void delete(int id) throws Exception {
        studentRepositoryJpa.deleteById(id);
    }

    @Override
    public void delete() throws Exception {
        studentRepositoryJpa.deleteAll();
    }
}
