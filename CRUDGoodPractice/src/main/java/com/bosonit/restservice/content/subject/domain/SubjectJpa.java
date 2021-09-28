package com.bosonit.restservice.content.subject.domain;

import com.bosonit.restservice.content.student.domain.StudentJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASIGNATURA")
public class SubjectJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_asignatura;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    private Set<StudentJpa> students = new HashSet<>();

    @Column
    private String asignatura;

    @Column
    private String comments;

    @Column(nullable = false)
    private Date initial_date;

    @Column
    private Date finish_date;

    public SubjectJpa(Subject subject) {
        this.asignatura = subject.getAsignatura();
        this.initial_date = subject.getInitial_date();
        if (subject.getStudents() != null)
            this.students = subject.getStudents().stream()
                    .map(StudentJpa::new)
                    .collect(Collectors.toSet());
        this.finish_date = subject.getFinish_date();
        this.id_asignatura = subject.getId_asignatura();
        this.comments = subject.getComments();
    }
}
