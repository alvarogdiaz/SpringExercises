package com.bosonit.restservice.content.person.infrastructure.repository.port;

import com.bosonit.restservice.content.person.domain.Person;

import java.util.HashMap;
import java.util.List;

public interface FindPersonPort {
    List<Person> findAll() throws Exception;
    Person findById(int id) throws Exception;
    List<Person> findByName(String name) throws Exception;
    List<Person> findByUser(String user) throws Exception;
    List<Person> getData(HashMap<String, Object> cond) throws Exception;
}
