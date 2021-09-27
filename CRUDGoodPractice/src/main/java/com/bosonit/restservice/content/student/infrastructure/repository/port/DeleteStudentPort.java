package com.bosonit.restservice.content.student.infrastructure.repository.port;

public interface DeleteStudentPort {
    void delete(String id) throws Exception;
    void delete() throws Exception;
}
