package com.bosonit.restservice.content.subject.infrastructure.controller.dto.output;

import com.bosonit.restservice.content.student.infrastructure.controller.dto.output.SimpleStudentOutputDTO;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.SubjectJpa;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class SubjectOutputDTO extends SimpleSubjectOutputDTO
        implements Serializable {
    protected Set<SimpleStudentOutputDTO> students;

    public SubjectOutputDTO(Subject subject) {
        super(subject);
        if (subject.getStudents() != null)
            this.setStudents(subject.getStudents().stream()
                    .map(SimpleStudentOutputDTO::new)
                    .collect(Collectors.toSet()));
    }

    public SubjectOutputDTO(SubjectJpa subjectJpa) {
        super(subjectJpa);
        if (subjectJpa.getStudents() != null)
            this.setStudents(subjectJpa.getStudents().stream()
                    .map(SimpleStudentOutputDTO::new)
                    .collect(Collectors.toSet()));
    }
}
