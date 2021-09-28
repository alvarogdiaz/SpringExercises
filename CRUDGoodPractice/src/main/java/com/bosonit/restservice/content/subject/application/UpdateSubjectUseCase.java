package com.bosonit.restservice.content.subject.application;

import com.bosonit.restservice.content.subject.application.port.UpdateSubjectPort;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.FindSubjectPort;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.SaveSubjectPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateSubjectUseCase implements UpdateSubjectPort {

    private SaveSubjectPort saveSubjectPort;
    private FindSubjectPort findSubjectPort;

    @Override
    public Subject update(String id_subject, SaveSubject saveSubject)
            throws Exception {
        Subject subject = findSubjectPort.findById(id_subject);
        subject.update(saveSubject);
        return saveSubjectPort.save(subject);
    }
}
