package com.bosonit.restservice.content.teacher.infrastructure.controller.dto.output;

import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.domain.TeacherJpa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleTeacherOutputDTO implements Serializable {
    protected String id_profesor;
    protected String branch;
    protected String comments;

    public SimpleTeacherOutputDTO(Teacher teacher) {
        this.setId_profesor(teacher.getId());
        this.setBranch(teacher.getBranch());
        this.setComments(teacher.getComments());
    }

    public SimpleTeacherOutputDTO(TeacherJpa teacherJpa) {
        this.setId_profesor(teacherJpa.getId());
        this.setBranch(teacherJpa.getBranch());
        this.setComments(teacherJpa.getComments());
    }

}
