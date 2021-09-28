package com.bosonit.restservice.content.subject.domain;

import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.input.SimpleSubjectInputDTO;

import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    private String id;

    private String asignatura;
    private String comments;
    private Date initial_date = new Date();
    private Date finish_date;

    private SubjectJpa subjectJpa;

    public Subject(SubjectJpa subjectJpa) {
        if (subjectJpa == null) return;

        this.subjectJpa = subjectJpa;
        this.id = subjectJpa.getId();
        this.initial_date = subjectJpa.getInitial_date();
        this.asignatura = subjectJpa.getAsignatura();
        this.finish_date = subjectJpa.getFinish_date();
        this.comments = subjectJpa.getComments();
    }

    public Subject(SimpleSubjectInputDTO subjectInputDTO) {
        this.asignatura = subjectInputDTO.getAsignatura();
        this.finish_date = subjectInputDTO.getFinish_date();
        this.comments = subjectInputDTO.getComments();
    }

    public void update(SaveSubject saveSubject) {
        if (saveSubject.getAsignatura() != null)
            this.asignatura = saveSubject.getAsignatura();
        if (saveSubject.getFinish_date() != null)
            this.finish_date = saveSubject.getFinish_date();
        if (saveSubject.getComments() != null)
            this.comments = saveSubject.getComments();
        if (saveSubject.getInitial_date() != null)
            this.initial_date = saveSubject.getInitial_date();
    }
}
