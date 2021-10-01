package com.bosonit.restservice.content.teacher.infrastructure.repository.port;

import com.bosonit.restservice.content.teacher.domain.Teacher;

public interface SaveTeacherPort {
    Teacher save(Teacher teacher) throws Exception;
}
