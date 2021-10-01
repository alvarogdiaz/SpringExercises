package com.bosonit.restservice.content.subject.infrastructure.repository.port;

public interface DeleteSubjectPort {
    void delete(int id) throws Exception;
    void delete() throws Exception;
}
