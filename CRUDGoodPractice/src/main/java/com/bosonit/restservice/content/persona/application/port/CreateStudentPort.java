package com.bosonit.restservice.content.persona.application.port;

import com.bosonit.restservice.content.persona.domain.Student;
import com.bosonit.restservice.content.persona.domain.noDatabase.SaveStudent;

public interface CreateStudentPort {
    Student create(SaveStudent saveStudent, int id) throws Exception;
}
