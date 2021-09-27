package com.bosonit.restservice.content.student.domain;

import com.bosonit.restservice.content.persona.domain.PersonaJpa;
import com.bosonit.restservice.content.persona.domain.Profesor;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.student.infrastructure.controller.dto.input.StudentInputDTO;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String id_student;
    private PersonaJpa id_persona;
    private Set<Profesor> id_profesor;

    private Integer num_hours_week;
    private String comments;
    private String branch;

    private StudentJpa studentJpa;

    public Student(StudentJpa studentJpa) {
        if (studentJpa == null) return;

        this.id_student = studentJpa.getId_student();
        this.id_persona = studentJpa.getId_persona();
        //this.id_profesor = studentJpa.getId_profesor();
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
        if (saveStudent.getBranch() != null)
            this.branch = saveStudent.getBranch();
        if (saveStudent.getComments() != null)
            this.comments = saveStudent.getComments();
        if (saveStudent.getNum_hours_week() != null)
            this.num_hours_week = saveStudent.getNum_hours_week();
    }
}
