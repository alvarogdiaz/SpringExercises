package com.bosonit.restservice.content.subject.domain;

import com.bosonit.restservice.content.student.domain.Student;
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

    private String id_asignatura;
    private Set<Student> students = new HashSet<>();

    private String asignatura;
    private String comments;
    private Date initial_date = new Date();
    private Date finish_date;

    private SubjectJpa subjectJpa;

    public Subject(SubjectJpa subjectJpa) {
        if (subjectJpa == null) return;

        this.id_asignatura = subjectJpa.getId_asignatura();
        if (subjectJpa.getStudents() != null)
            this.students = subjectJpa.getStudents().stream()
                .map(Student::new)
                .collect(Collectors.toSet());
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
        if (saveSubject.getStudents() != null)
            this.students = saveSubject.getStudents();
    }

    public void addStudent(Student student) {
        if (this.students == null)
            this.students = new HashSet<>();

        this.students.add(student);
    }
}
