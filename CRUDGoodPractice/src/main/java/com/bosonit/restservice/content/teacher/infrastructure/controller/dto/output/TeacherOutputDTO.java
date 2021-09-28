package com.bosonit.restservice.content.teacher.infrastructure.controller.dto.output;

import com.bosonit.restservice.content.person.infrastructure.controller.dto.output.PersonOutputDTO;
import com.bosonit.restservice.content.student.infrastructure.controller.dto.output.SimpleStudentOutputDTO;
import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.domain.TeacherJpa;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class TeacherOutputDTO extends SimpleTeacherOutputDTO
        implements Serializable {
    protected PersonOutputDTO id_persona;
    //protected Set<SimpleStudentOutputDTO> students;

    public TeacherOutputDTO(Teacher teacher) {
        super(teacher);
        if (teacher.getId() != null)
            this.setId_persona(new PersonOutputDTO(teacher.getId_persona()));

        //this.students = teacher.getStudents().stream().map(SimpleStudentOutputDTO::new).collect(Collectors.toSet());
    }

    public TeacherOutputDTO(TeacherJpa teacherJpa) {
        super(teacherJpa);
        if (teacherJpa.getId() != null)
            this.setId_persona(new PersonOutputDTO(teacherJpa.getId_persona()));

        //this.students = teacherJpa.getStudents().stream().map(SimpleStudentOutputDTO::new).collect(Collectors.toSet());
    }
}
