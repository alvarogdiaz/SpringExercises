package com.bosonit.restservice.content.persona.infrastructure.repository.port;

public interface DeleteStudentPort {
    void delete(String id) throws Exception;
    void delete() throws Exception;
}
