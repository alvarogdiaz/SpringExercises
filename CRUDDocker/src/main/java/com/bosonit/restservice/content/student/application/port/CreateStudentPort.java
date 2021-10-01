package com.bosonit.restservice.content.student.application.port;

import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;

public interface CreateStudentPort {
    Student create(SaveStudent saveStudent, int id_person) throws Exception;
    Student create(SaveStudent saveStudent, SavePerson savePersona) throws Exception;
}
