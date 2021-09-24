package com.bosonit.restservice.content.persona.infrastructure.controller.dto.output;

import com.bosonit.restservice.content.persona.domain.Student;
import com.bosonit.restservice.content.persona.domain.StudentJpa;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class StudentOutputDTO extends SimpleStudentOutputDTO
        implements Serializable {
    protected PersonaOutputDTO id_persona;

    public StudentOutputDTO(Student student) {
        super(student);
        this.setId_persona(new PersonaOutputDTO(student.getId_persona()));
    }

    public StudentOutputDTO(StudentJpa studentJpa) {
        super(studentJpa);
        this.setId_persona(new PersonaOutputDTO(studentJpa.getId_persona()));
    }
}
