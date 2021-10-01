package com.bosonit.restservice.content.teacher.infrastructure.repository.port;

public interface DeleteTeacherPort {
    void delete(int id) throws Exception;
    void delete() throws Exception;
}
