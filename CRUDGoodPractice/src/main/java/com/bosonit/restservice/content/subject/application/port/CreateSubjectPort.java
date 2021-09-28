package com.bosonit.restservice.content.subject.application.port;

import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;

public interface CreateSubjectPort {
    Subject create(SaveSubject saveSubject, String id_person) throws Exception;
}
