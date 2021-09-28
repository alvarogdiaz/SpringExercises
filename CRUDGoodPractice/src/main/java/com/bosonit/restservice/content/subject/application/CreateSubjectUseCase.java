package com.bosonit.restservice.content.subject.application;

import com.bosonit.restservice.content.student.infrastructure.repository.port.FindStudentPort;
import com.bosonit.restservice.content.subject.application.port.CreateSubjectPort;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.SaveSubjectPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateSubjectUseCase implements CreateSubjectPort {

    private SaveSubjectPort saveSubjectPort;
    private FindStudentPort findStudentPort;

    @Override
    public Subject create(SaveSubject saveSubject, String id_student) throws Exception {
        Subject subject = new Subject();
        if (id_student != null)
            subject.addStudent(findStudentPort.findById(id_student));
        subject.update(saveSubject);

        return saveSubjectPort.save(subject);
    }
}
