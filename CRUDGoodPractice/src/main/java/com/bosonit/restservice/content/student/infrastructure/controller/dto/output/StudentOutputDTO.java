package com.bosonit.restservice.content.student.infrastructure.controller.dto.output;

import com.bosonit.restservice.content.subject.infrastructure.controller.dto.output.SimpleSubjectOutputDTO;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.output.SimpleTeacherOutputDTO;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.StudentJpa;
import com.bosonit.restservice.content.person.infrastructure.controller.dto.output.PersonOutputDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class StudentOutputDTO extends SimpleStudentOutputDTO
        implements Serializable {
    protected PersonOutputDTO id_persona;
    protected SimpleTeacherOutputDTO id_profesor;
    //protected Set<SimpleSubjectOutputDTO> subjects;

    public StudentOutputDTO(Student student) {
        super(student);
        this.setId_persona(new PersonOutputDTO(student.getId_persona()));
        /*this.setSubjects(student.getSubjects().stream()
                .map(SimpleSubjectOutputDTO::new)
                .collect(Collectors.toSet()));*/
        if (student.getTeacher() != null)
            this.setId_profesor(new SimpleTeacherOutputDTO(student.getTeacher()));
    }

    public StudentOutputDTO(StudentJpa studentJpa) {
        super(studentJpa);
        this.setId_persona(new PersonOutputDTO(studentJpa.getId_persona()));
        /*this.setSubjects(studentJpa.getSubjects().stream()
                .map(SimpleSubjectOutputDTO::new)
                .collect(Collectors.toSet()));*/
        if (studentJpa.getTeacher() != null)
            this.setId_profesor(new SimpleTeacherOutputDTO(studentJpa.getTeacher()));
    }
}
