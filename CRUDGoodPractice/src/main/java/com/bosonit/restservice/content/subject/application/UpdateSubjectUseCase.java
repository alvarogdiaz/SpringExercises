package com.bosonit.restservice.content.subject.application;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.infrastructure.repository.port.FindStudentPort;
import com.bosonit.restservice.content.subject.application.port.UpdateSubjectPort;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.output.SubjectOutputDTO;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.FindSubjectPort;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.SaveSubjectPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateSubjectUseCase implements UpdateSubjectPort {

    private SaveSubjectPort saveSubjectPort;
    private FindSubjectPort findSubjectPort;
    private FindStudentPort findStudentPort;

    @Override
    public Subject update(String id_subject, String id_student, SaveSubject saveSubject)
            throws Exception {

        Subject subject = findSubjectPort.findById(id_subject);

        if (id_student != null)
            subject.addStudent(findStudentPort.findById(id_student));

        subject.update(saveSubject);
        return saveSubjectPort.save(subject);
    }

    @Override
    public Subject addSubject(String id_student, String id_subject) throws Exception {
        Student student = findStudentPort.findById(id_student);
        Subject subject = findSubjectPort.findById(id_subject);

        subject.addStudent(student);
        return saveSubjectPort.save(subject);
    }
}
