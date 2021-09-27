package com.bosonit.restservice.content.student.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleStudentInputDTO extends StudentInput implements Serializable {
    private Integer id_persona;
}
