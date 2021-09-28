package com.bosonit.restservice.content.teacher.application.port;

import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.domain.noDatabase.SaveTeacher;

public interface CreateTeacherPort {
    Teacher create(SaveTeacher saveTeacher, int id) throws Exception;
    Teacher create(SaveTeacher saveTeacher, SavePerson savePerson) throws Exception;
}
