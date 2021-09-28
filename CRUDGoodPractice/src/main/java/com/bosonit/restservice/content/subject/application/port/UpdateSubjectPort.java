package com.bosonit.restservice.content.subject.application.port;

import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;

public interface UpdateSubjectPort {
    Subject update(String id_subject, SaveSubject saveSubject) throws Exception;
}
