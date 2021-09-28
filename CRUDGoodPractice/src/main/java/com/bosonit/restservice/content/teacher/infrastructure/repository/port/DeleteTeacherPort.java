package com.bosonit.restservice.content.teacher.infrastructure.repository.port;

public interface DeleteTeacherPort {
    void delete(String id) throws Exception;
    void delete() throws Exception;
}
