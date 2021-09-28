package com.bosonit.restservice.content.student.domain;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.student.infrastructure.controller.dto.output.SimpleStudentOutputDTO;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.SubjectJpa;
import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.student.infrastructure.controller.dto.input.StudentInputDTO;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String id_student;
    private Person id_persona;
    private Teacher teacher;

    private Integer num_hours_week;
    private String comments;
    private String branch;

    private Set<Subject> subjects = new HashSet<>();

    private StudentJpa studentJpa;

    public Student(StudentJpa studentJpa) {
        if (studentJpa == null) return;

        this.id_student = studentJpa.getId_student();
        this.id_persona = new Person(studentJpa.getId_persona());
        if (studentJpa.getTeacher() != null)
            this.teacher = new Teacher(studentJpa.getTeacher());
        this.num_hours_week = studentJpa.getNum_hours_week();
        this.branch = studentJpa.getBranch();
        this.comments = studentJpa.getComments();
    }

    public Student(StudentInputDTO studentInputDTO) {
        this.num_hours_week = studentInputDTO.getNum_hours_week();
        this.branch = studentInputDTO.getBranch();
        this.comments = studentInputDTO.getComments();
    }

    public void update(SaveStudent saveStudent) {
        if (saveStudent.getId_persona() != null)
            this.id_persona = saveStudent.getId_persona();
        if (saveStudent.getTeacher() != null)
            this.teacher = saveStudent.getTeacher();
        if (saveStudent.getBranch() != null)
            this.branch = saveStudent.getBranch();
        if (saveStudent.getComments() != null)
            this.comments = saveStudent.getComments();
        if (saveStudent.getNum_hours_week() != null)
            this.num_hours_week = saveStudent.getNum_hours_week();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}