package com.bosonit.restservice.content.student.application.port;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;

public interface UpdateStudentPort {
    Student update(String id_student, SaveStudent saveStudent) throws Exception;
    Student update(String id_student, int id_person, SaveStudent saveStudent) throws Exception;
}
