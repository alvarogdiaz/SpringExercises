package com.bosonit.restservice.content.persona.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaInputDTO {

    private String id_student;

    private String asignatura;
    private String comments;
    private Date finish_date;

}
