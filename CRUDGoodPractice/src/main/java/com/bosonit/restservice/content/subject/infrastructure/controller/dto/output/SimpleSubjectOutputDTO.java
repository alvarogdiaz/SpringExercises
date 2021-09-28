package com.bosonit.restservice.content.subject.infrastructure.controller.dto.output;

import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.SubjectJpa;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class SimpleSubjectOutputDTO implements Serializable {
    protected String id_asignatura;
    protected String asignatura;
    protected String comments;
    protected Date initial_date;
    protected Date finish_date;

    public SimpleSubjectOutputDTO(Subject subject) {
        this.setComments(subject.getComments());
        this.setId_asignatura(subject.getId());
        this.setFinish_date(subject.getFinish_date());
        this.setInitial_date(subject.getInitial_date());
        this.setAsignatura(subject.getAsignatura());
    }

    public SimpleSubjectOutputDTO(SubjectJpa subjectJpa) {
        this.setId_asignatura(subjectJpa.getId());
        this.setFinish_date(subjectJpa.getFinish_date());
        this.setInitial_date(subjectJpa.getInitial_date());
        this.setAsignatura(subjectJpa.getAsignatura());
        this.setComments(subjectJpa.getComments());
    }

}
