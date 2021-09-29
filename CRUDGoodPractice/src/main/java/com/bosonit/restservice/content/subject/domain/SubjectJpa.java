package com.bosonit.restservice.content.subject.domain;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.StudentJpa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUBJECT")
public class SubjectJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToMany(mappedBy = "subjects"/*, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY*/)
    private List<StudentJpa> students;// = new HashSet<>();

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
        this.finish_date = subject.getFinish_date();
        this.id = subject.getId();
        this.comments = subject.getComments();
        this.students = subject.getStudents().stream()
                .map(StudentJpa::new)
                .collect(Collectors.toList());
    }
}
