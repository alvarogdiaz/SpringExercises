package com.bosonit.restservice.content.subject.infrastructure.repository.port;

import com.bosonit.restservice.content.subject.domain.Subject;

public interface SaveSubjectPort {
    Subject save(Subject subject) throws Exception;
}
