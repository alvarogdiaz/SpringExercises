package com.bosonit.restservice.content.subject.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectInputDTO extends SimpleSubjectInputDTO implements Serializable {
    private Integer id_student;
}
