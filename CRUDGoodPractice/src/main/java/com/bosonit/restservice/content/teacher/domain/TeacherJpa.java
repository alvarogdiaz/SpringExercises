package com.bosonit.restservice.content.teacher.domain;

import com.bosonit.restservice.content.person.domain.PersonJpa;
import com.bosonit.restservice.content.student.domain.StudentJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROFESOR")
public class TeacherJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona")
    private PersonJpa id_persona;

    @Column
    private String comments;

    @Column(nullable = false)
    private String branch;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<StudentJpa> students = new HashSet<>();

    public TeacherJpa(Teacher teacher) {
        this.id = teacher.getId();
        if (teacher.getId_persona() != null)
            this.id_persona = new PersonJpa(teacher.getId_persona());
        this.branch = teacher.getBranch();
        this.comments = teacher.getComments();
        /*System.out.println(teacher);
        this.students = teacher.getStudents().stream()
                .map(StudentJpa::new)
                .collect(Collectors.toSet());
        System.out.println(students);*/
    }

}
