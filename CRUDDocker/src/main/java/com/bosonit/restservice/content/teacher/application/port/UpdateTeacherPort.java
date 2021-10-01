package com.bosonit.restservice.content.teacher.application.port;

import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.domain.noDatabase.SaveTeacher;

public interface UpdateTeacherPort {
    Teacher update(int id_profesor, Integer id_person, SaveTeacher saveTeacher) throws Exception;
}
