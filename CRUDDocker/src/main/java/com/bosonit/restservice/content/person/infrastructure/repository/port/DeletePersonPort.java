package com.bosonit.restservice.content.person.infrastructure.repository.port;

public interface DeletePersonPort {
    void delete(int id) throws Exception;
    void delete() throws Exception;
}
