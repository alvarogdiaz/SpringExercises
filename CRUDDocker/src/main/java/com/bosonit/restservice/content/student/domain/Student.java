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
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;

    private Person id_persona;
    private Teacher teacher;

    private Integer num_hours_week;
    private String comments;
    private String branch;

    private List<Subject> subjects;

    private StudentJpa studentJpa;

    public Student(StudentJpa studentJpa) {
        if (studentJpa == null) return;

        this.studentJpa = studentJpa;
        this.id = studentJpa.getId();
        this.id_persona = new Person(studentJpa.getId_persona());
        if (studentJpa.getTeacher() != null)
            this.teacher = new Teacher(studentJpa.getTeacher());
        this.num_hours_week = studentJpa.getNum_hours_week();
        this.branch = studentJpa.getBranch();
        this.comments = studentJpa.getComments();
        if (studentJpa.getSubjects() != null)
            this.subjects = studentJpa.getSubjects().stream()
                .map(Subject::new)
                .collect(Collectors.toList());
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
}
