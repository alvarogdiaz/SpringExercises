package com.bosonit.restservice.content.student.application.port;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.input.SimpleSubjectInputDTO;

import java.util.List;

public interface UpdateStudentPort {
    Student update(int id_student, Integer id_person, Integer id_profesor, SaveStudent saveStudent) throws Exception;
    Student addSubjects(int id_student,  List<Integer> id_subject) throws Exception;
    Student unsubscribeSubjects(int id_student, List<Integer> id_subject) throws Exception;
    Student teacher(int id_student, int id_teacher) throws Exception;
}
