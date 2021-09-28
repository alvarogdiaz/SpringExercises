package com.bosonit.restservice.content.teacher.domain;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.teacher.domain.noDatabase.SaveTeacher;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.input.TeacherInputDTO;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private String id;
    private Person id_persona;

    private String comments;
    private String branch;

    private TeacherJpa teacherJpa;

    public Teacher(TeacherJpa teacherJpa) {
        if (teacherJpa == null) return;

        this.id = teacherJpa.getId();
        this.id_persona = new Person(teacherJpa.getId_persona());
        this.branch = teacherJpa.getBranch();
        /*this.students = teacherJpa.getStudents().stream()
                .map(Student::new)
                .collect(Collectors.toSet());
        */
        this.comments = teacherJpa.getComments();
    }

    public Teacher(TeacherInputDTO profesorInputDTO) {
        this.branch = profesorInputDTO.getBranch();
        this.comments = profesorInputDTO.getComments();
    }

    public void update(SaveTeacher saveTeacher) {
        if (saveTeacher.getId_persona() != null)
            this.id_persona = saveTeacher.getId_persona();
        if (saveTeacher.getBranch() != null)
            this.branch = saveTeacher.getBranch();
        if (saveTeacher.getComments() != null)
            this.comments = saveTeacher.getComments();
    }
}
