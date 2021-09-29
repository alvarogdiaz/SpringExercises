package com.bosonit.restservice.content.student.domain;

import com.bosonit.restservice.content.person.domain.PersonJpa;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.SubjectJpa;
import com.bosonit.restservice.content.teacher.domain.TeacherJpa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT")
public class StudentJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona")
    private PersonJpa id_persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher")
    private TeacherJpa teacher;

    @Column(nullable = false)
    private Integer num_hours_week;

    @Column
    private String comments;

    @Column(nullable = false)
    private String branch;

    @ManyToMany( cascade = CascadeType.ALL)/*(cascade = { CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST },
            fetch = FetchType.LAZY)*/
    @JoinTable(name = "student_subjects",
                joinColumns = {@JoinColumn(name = "id_student")},
                inverseJoinColumns = {@JoinColumn(name = "id_subject")})
    private List<SubjectJpa> subjects;

    public StudentJpa(Student student) {
        this.id = student.getId();
        this.id_persona = new PersonJpa(student.getId_persona());
        if (student.getTeacher() != null)
            this.teacher = new TeacherJpa(student.getTeacher());
        this.num_hours_week = student.getNum_hours_week();
        this.branch = student.getBranch();
        this.comments = student.getComments();
        if (student.getSubjects() != null) {
            this.subjects=student.getSubjects().stream()
                    .map(SubjectJpa::new)
                    .collect(Collectors.toList());
        }
    }

}
