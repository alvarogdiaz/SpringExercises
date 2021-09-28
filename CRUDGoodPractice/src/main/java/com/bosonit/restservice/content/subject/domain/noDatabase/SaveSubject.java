package com.bosonit.restservice.content.subject.domain.noDatabase;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.subject.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveSubject extends Subject {

    private String asignatura;
    private String comments;
    private Date initial_date;
    private Date finish_date;

    public SaveSubject(Subject subject) {
        this.asignatura = subject.getAsignatura();
        this.initial_date = subject.getInitial_date();
        this.finish_date = subject.getFinish_date();
        this.comments = subject.getComments();
    }
}
