package com.bosonit.restservice.content.person.infrastructure.repository.port;

import com.bosonit.restservice.content.person.domain.Person;

import java.util.HashMap;
import java.util.List;

public interface FindPersonPort {
    List<Person> findAll(int num, int size) throws Exception;
    Person findById(int id) throws Exception;
    List<Person> findByName(String name, int num, int size) throws Exception;
    List<Person> findByUser(String user, int num, int size) throws Exception;
    List<Person> getData(HashMap<String, Object> cond, int num, int size) throws Exception;
}
