package com.bosonit.restservice.content.student.application.port;

import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;

public interface CreateStudentPort {
    Student create(SaveStudent saveStudent, int id) throws Exception;
    Student create(SaveStudent saveStudent, SavePersona savePersona) throws Exception;
}
