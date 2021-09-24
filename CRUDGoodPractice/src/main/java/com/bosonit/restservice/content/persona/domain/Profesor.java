package com.bosonit.restservice.content.persona.domain;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {

    private String id_persona;
    private String id_profesor;

    private String comments;
    private String branch;

    private Set<String> students;

    private ProfesorJpa profesorJpa;

}
