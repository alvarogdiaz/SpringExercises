package com.bosonit.restservice.content.student.application.port;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.input.SimpleSubjectInputDTO;

import java.util.List;

public interface UpdateStudentPort {
    Student update(String id_student, Integer id_person, String id_profesor, SaveStudent saveStudent) throws Exception;
    Student addSubject(String id_student, String id_subject) throws Exception;
    Student addSubjects(String id_student, List<String> id_subject) throws Exception;
    Student teacher(String id_student, String id_teacher) throws Exception;
}
