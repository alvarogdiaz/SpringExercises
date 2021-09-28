package com.bosonit.restservice.content.subject.application.port;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;

public interface UpdateSubjectPort {
    Subject update(String id_subject, String id_student, SaveSubject saveSubject) throws Exception;
    Subject addSubject(String id_student, String id_subject) throws Exception;
}
