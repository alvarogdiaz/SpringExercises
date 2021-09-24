package com.bosonit.restservice.content.persona.domain;

import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String id_student;
    private String id_persona;
    private String id_profesor;

    private int num_hours_week;
    private String comments;
    private String branch;

    private StudentJpa studentJpa;

}
