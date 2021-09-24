package com.bosonit.restservice.content.persona.infrastructure.controller.dto.output;

import com.bosonit.restservice.content.persona.domain.Student;
import com.bosonit.restservice.content.persona.domain.StudentJpa;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class SimpleStudentOutputDTO implements Serializable {
    protected String id_student;
    protected String branch;
    protected String comments;
    protected Integer num_hours_week;

    public SimpleStudentOutputDTO(Student student) {
        this.setId_student(student.getId_student());
        this.setBranch(student.getBranch());
        this.setComments(student.getComments());
        this.setNum_hours_week(student.getNum_hours_week());
    }

    public SimpleStudentOutputDTO(StudentJpa studentJpa) {
        this.setId_student(studentJpa.getId_student());
        this.setBranch(studentJpa.getBranch());
        this.setComments(studentJpa.getComments());
        this.setNum_hours_week(studentJpa.getNum_hours_week());
    }

}
