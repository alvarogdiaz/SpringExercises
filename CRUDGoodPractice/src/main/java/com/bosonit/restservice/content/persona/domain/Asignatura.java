package com.bosonit.restservice.content.persona.domain;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {

    private String id_asignatura;
    private String id_student;

    private String asignatura;
    private String comments;
    private Date initial_date;
    private Date finish_date;

    private AsignaturaJpa asignaturaJpa;

}
