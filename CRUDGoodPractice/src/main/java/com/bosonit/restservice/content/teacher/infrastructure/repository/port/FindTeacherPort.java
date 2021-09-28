package com.bosonit.restservice.content.teacher.infrastructure.repository.port;

import com.bosonit.restservice.content.teacher.domain.Teacher;

import java.util.List;

public interface FindTeacherPort {
    List<Teacher> findAll() throws Exception;
    Teacher findById(String id) throws Exception;
    List<Teacher> findByBranch(String branch) throws Exception;
}
