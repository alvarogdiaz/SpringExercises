package com.bosonit.restservice.content.student.infrastructure.repository.port;

public interface DeleteStudentPort {
    void delete(int id) throws Exception;
    void delete() throws Exception;
}
